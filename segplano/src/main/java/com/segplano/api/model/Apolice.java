package com.segplano.api.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Apolice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	
	@NotNull(message = "Data de início da vigência é obrigatória")
	private LocalDate inicioVigencia;
	
	@NotNull(message = "Data de fim da vigência é obrigatória")
	private LocalDate fimVigencia;
	
	@NotEmpty(message = "Placa é obrigatória")
	@Pattern(message="Placa inválida.", regexp = "^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
	private String placa;
	
	@NotNull(message = "Valor é obrigatório")
	private BigDecimal valor;		
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@Transient
	private boolean vencida;
	
	@Transient
	private long diasVencimento;
	
	@Transient
	private long diasParaVencimento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apolice other = (Apolice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	public boolean isVencida() {
		return vencida;
	}
	public void setVencida(boolean vencida) {
		this.vencida = vencida;
	}
	public long getDiasVencimento() {
		return diasVencimento;
	}
	public void setDiasVencimento(long diasVencimento) {
		this.diasVencimento = diasVencimento;
	}
	public long getDiasParaVencimento() {
		return diasParaVencimento;
	}
	public void setDiasParaVencimento(long diasParaVencimento) {
		this.diasParaVencimento = diasParaVencimento;
	}
	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}
	public void setInicioVigencia(LocalDate inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	public LocalDate getFimVigencia() {
		return fimVigencia;
	}
	public void setFimVigencia(LocalDate fimVigencia) {
		this.fimVigencia = fimVigencia;
	}	
	
}
