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

  //exibeMensagemSucesso = false;
  //exibeMensagemErro = false;
  mensagemErro = '';
  mensagemSucesso = '';
   
  constructor(
    private clienteService: ClienteService, 
    private apoliceService: ApoliceService) { }

  ngOnInit() {
    this.clienteService.listar().subscribe(listaClientes => {
      console.log(listaClientes);
      this.clientes = listaClientes;
    });
    this.atualizarTela();
  }

  salvarApolice() {
    this.apolice.cliente = this.clienteSel;
    console.log( Date.parse(this.apolice.inicioVigencia) );
    this.apoliceService.salvar(this.apolice).subscribe(apoliceSalva => {
      this.mensagemSucesso = "Apolice salva com sucesso!";
      this.limparCampos();
      this.atualizarTela();
    },
    exept => {
      this.mensagemSucesso = '';
      this.mensagemErro = exept.error.message;
    });
  }

  limparCampos() {
    this.apolice = <Apolice>{};
    this.clienteSel = <Cliente>{id: 0};
  }

  atualizarTela() {
    this.apoliceService.listar().subscribe(apolicesRetorno => {
      this.apolices = apolicesRetorno;
    });
  }

  editar(apoliceEdit: Apolice) {
    console.log(apoliceEdit);
    this.mensagemSucesso = '';
    this.mensagemErro = '';
    this.clienteSel = apoliceEdit.cliente;
    this.apolice = {...apoliceEdit};
  }

  remover(apoliceDel: Apolice) {
    this.apoliceService.remover(apoliceDel).subscribe( () => {
      this.mensagemSucesso = 'Apólice removida com sucesso';
      this.atualizarTela();
    },
    exept => {
      console.log(exept);
      this.mensagemSucesso = '';
      this.mensagemErro = exept.error.message;
    });
  }

}
