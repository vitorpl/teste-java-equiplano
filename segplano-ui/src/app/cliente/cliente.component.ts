import { Estado } from './../model/estado';
import { Component, OnInit } from '@angular/core';
import { Cidade } from '../model/cidade';
import { Cliente } from '../model/cliente';
import { EstadoService } from '../services/estado.service';
import { CidadeService } from '../services/cidade.service';
import { ClienteService } from '../services/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  cliente: Cliente = <Cliente>{};

  cidades: Cidade[] = [];
  cidadeSel: Cidade = <Cidade>{"id":0};

  estados: Estado[] = [];
  estadoSel: Estado = <Estado>{"id":0};

  listaClientes: Cliente[] = [];

  loadingCidade: boolean = false;

  exibeMensagemSucesso = false;
  exibeMensagemErro = false;
  mensagemErro = '';

  constructor(
    private clienteService: ClienteService,
    private estadoService: EstadoService,
    private cidadeService: CidadeService
    ) { }

  ngOnInit() {
    this.limparCampos();
    this.exibeMensagemSucesso = false;
    this.estadoService.listar().subscribe(estadosRetorno => {
      this.estados = estadosRetorno;
      console.log(this.estados);
      console.log(this.cliente);
    });

    this.atualizarTela();
  }

  atualizarTela() {
    this.clienteService.listar().subscribe(clientesRetorno => {
      this.listaClientes = clientesRetorno
    });
  }

  mudaEstado() {
    this.cliente.estado = this.estadoSel;
    this.loadingCidade = true;
    this.cidadeService.listarPorEstado(this.cliente.estado).subscribe(cidadesRetorno => {
      this.cidades = cidadesRetorno;
      this.loadingCidade = false;
    });
  }

  salvarCliente() {
    console.log(this.cidadeSel);
    this.cliente.cidade = this.cidadeSel;
    console.log(this.cliente);

    this.clienteService.salvar(this.cliente).subscribe(clienteSalvo => {
      console.log("Cliente salvo com sucesso!");
      //alert("Cliente salvo com sucesso!");
      this.exibeMensagemSucesso = true;
      this.limparCampos();
      this.atualizarTela();
    },
    exept => {
      this.exibeMensagemErro = true;
      this.mensagemErro = exept.error.message;
    });
  } 

  limparCampos() {
    this.exibeMensagemErro = false;
    this.mensagemErro = '';
    this.cliente = <Cliente>{};
  }

  editar(clienteEdit: Cliente) {
    this.exibeMensagemSucesso = false;
    this.limparCampos();
    console.log(clienteEdit);
    this.cidadeSel = clienteEdit.cidade;
    this.estadoSel = clienteEdit.cidade.estado;
    this.mudaEstado();
    this.cliente = {...clienteEdit}; //evida que os dados do grid fiquem sendo alterados ao editar
  }

  remover(clienteDel: Cliente) {
    this.clienteService.remover(clienteDel).subscribe( () => {
      console.log('Cliente removido com sucesso');
      this.atualizarTela();
    },
    exept => {
      this.exibeMensagemErro = true;
      this.mensagemErro = exept.error.message;
    });
  }

}
