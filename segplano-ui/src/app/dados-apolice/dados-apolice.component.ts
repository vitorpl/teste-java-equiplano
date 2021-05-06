import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Apolice } from '../model/apolice';
import { ApoliceService } from '../services/apolice.service';

@Component({
  selector: 'app-dados-apolice',
  templateUrl: './dados-apolice.component.html',
  styleUrls: ['./dados-apolice.component.css']
})
export class DadosApoliceComponent implements OnInit {

  apolice: Apolice = <Apolice>{};
  apolicePesquisa: Apolice = <Apolice>{};

  mensagemErro = '';

  constructor(
    private apoliceService: ApoliceService
  ) { }

  ngOnInit() {
    this.mensagemErro = ''
  }

  pesquisarApolice() {
    console.log(this.apolice);
    let obsApolice: Observable<Apolice> = null;
    this.mensagemErro = ''

    if(this.apolice.numero) {
      console.log(this.apolice.numero);
       obsApolice = this.apoliceService.pesquisarPorNumero(this.apolice.numero);
    }
    else if(this.apolice.placa) {
      obsApolice = this.apoliceService.pesquisarPorPlaca(this.apolice.placa);
    }

    if(obsApolice) {
      obsApolice.subscribe(apoliceRetornoPesquisa => {
        this.apolicePesquisa = apoliceRetornoPesquisa;
        console.log(apoliceRetornoPesquisa);
      },
      except => {

        if(except.message.includes('404')) {
          this.mensagemErro = except.error.message;
        }
        else {
          this.mensagemErro = 'Ocorreu um erro o buscar os dados: '+except.message;
        }
      });
    }


  }

}
