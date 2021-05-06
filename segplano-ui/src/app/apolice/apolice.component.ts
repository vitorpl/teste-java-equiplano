import { Component, OnInit } from '@angular/core';
import { Apolice } from '../model/apolice';
import { Cliente } from '../model/cliente';
import { ApoliceService } from '../services/apolice.service';
import { ClienteService } from '../services/cliente.service';

@Component({
  selector: 'app-apolice',
  templateUrl: './apolice.component.html',
  styleUrls: ['./apolice.component.css']
})
export class ApoliceComponent implements OnInit {

  apolice: Apolice = <Apolice>{};
  apolices: Apolice[] = [];
  cliente: Cliente = <Cliente>{};
  clienteSel: Cliente = <Cliente>{id: 0};
  clientes: Cliente[] = [];
   
  constructor(
    private clienteService: ClienteService, 
    private apoliceService: ApoliceService) { }

  ngOnInit() {
    this.clienteService.listar().subscribe(listaClientes => {
      console.log(listaClientes);
      this.clientes = listaClientes;
    });
    this.apoliceService.listar().subscribe(apolicesRetorno => {
      this.apolices = apolicesRetorno;
    });
  }

  salvarApolice() {
    this.apolice.cliente = this.clienteSel;
    console.log( Date.parse(this.apolice.inicioVigencia) );
    this.apoliceService.salvar(this.apolice).subscribe(apoliceSalva => {
      console.log("Apolice salva com sucesso!");
      //alert("Cliente salvo com sucesso!");
      //this.exibeMensagemSucesso = true;
      //this.limparCampos();
      //this.atualizarTela();
    },
    exept => {
      //this.exibeMensagemErro = true;
      //this.mensagemErro = exept.error.message;
    });
  }

  editar() {

  }

  remover() {
    
  }

}
