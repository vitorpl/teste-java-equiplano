package com.segplano.api.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segplano.api.exception.ApoliceJaExisteException;
import com.segplano.api.exception.ApoliceNaoExisteException;
import com.segplano.api.model.Apolice;
import com.segplano.api.repository.ApoliceDao;
import com.segplano.api.util.Util;

@Service
public class ApoliceService {

	@Autowired
	private ApoliceDao dao;
	
	
	public void salvar(Apolice apolice) throws Exception {
		//validar cpf
		if(dao.findByPlaca(apolice.getPlaca()).isPresent()) {
			throw new ApoliceJaExisteException(apolice.getPlaca());
		}
		
		apolice.setNumero(this.gerarNumeroApolice());
		
		dao.save(apolice);
	}
	
	public void atualizar(Apolice apolice) {
		dao.save(apolice);
	}
	
	public List<Apolice> listar() {
		
		List<Apolice> apolices = dao.findAll();
		
		apolices.stream().forEach(apolice -> {
			setExtraInfo(apolice);
		});
		
		return apolices;
	}

	public void deleteById(Long id) {
		dao.deleteById(id);		
	}
	
	private void setExtraInfo(Apolice apolice) {
		apolice.setVencida(isApoliceVencida(apolice));
		apolice.setDiasVencimento(calcularQuantidadeDiasApoliceVencida(apolice));
		apolice.setDiasParaVencimento(calcularDiasParaVencimento(apolice));
		
	}

	public Apolice getApoliceById(Long id) throws ApoliceNaoExisteException {
		Apolice apolice = dao.findById(id).orElseThrow(() -> new ApoliceNaoExisteException(id));
		setExtraInfo(apolice);
		return apolice;
	}
	
	public Apolice getApoliceByNumero(String numero) throws ApoliceNaoExisteException {
		Apolice apolice = dao.findByNumero(numero).orElseThrow(() -> new ApoliceNaoExisteException(numero));
		setExtraInfo(apolice);
		return apolice;
	}
	
	public Apolice getApoliceByPlaca(String placa) throws ApoliceNaoExisteException {
		Apolice apolice = dao.findByPlaca(placa).orElseThrow(() -> new ApoliceNaoExisteException(placa));
		setExtraInfo(apolice);
		return apolice;
	}
	
	public boolean isApoliceVencida(Apolice apolice) {
		//apolice.getFimVigencia().
		Date dtaFimVigencia = Util.localDateToDate(apolice.getFimVigencia());
		return dtaFimVigencia.before(new Date());		
	}
	
	public long calcularQuantidadeDiasApoliceVencida(Apolice apolice) {
		LocalDate agora = LocalDate.now();
		
		/*LocalDate ldVigencia = apolice.getFimVigencia()
				.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();*/
		
		long diasVenc = ChronoUnit.DAYS.between(apolice.getFimVigencia(), agora);
		
		return diasVenc < 0 ? 0 : diasVenc;
	}
	
	
	public long calcularDiasParaVencimento(Apolice apolice) {
		LocalDate agora = LocalDate.now();
		/*LocalDate ldVigencia = apolice.getFimVigencia()
				.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();*/
		
		long diasParaVencimento = ChronoUnit.DAYS.between(agora, apolice.getFimVigencia());
		
		return diasParaVencimento < 0 ? 0 : diasParaVencimento;
	}
	
	public List<Apolice> listarApolicesVencidas() {
		List<Apolice> apolices = dao.listarApolicesVencidas();
		
		apolices.stream().forEach(apolice -> {
			setExtraInfo(apolice);
		});
		
		return apolices;
	}
	
	public String gerarNumeroApolice() {
		Calendar cal = Calendar.getInstance();
		Random rnd = new Random(cal.getTimeInMillis());
		String numero = String.valueOf(Math.abs(rnd.nextLong()));
		//String numero = "25160459539644890";
		
		//verifica se o número gerado é igual a algum já existente
		try {
			while(getApoliceByNumero(numero) != null) {
				System.out.println("conflito de número gerando outro..");
				rnd = new Random(cal.getTimeInMillis());
				numero = String.valueOf(Math.abs(rnd.nextLong()));
			}
		} catch (ApoliceNaoExisteException e) {
			System.out.println("Código gerado: "+numero);
		}
		
		return numero; 
	}
	
}