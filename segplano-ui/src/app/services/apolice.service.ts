import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Apolice } from '../model/apolice';
import { Util } from '../util/util';

@Injectable({
  providedIn: 'root'
})
export class ApoliceService {

  
  private readonly URL = Util.getBaseUrl()+'api/apolices';

  constructor(private http: HttpClient) { }

  listar(): Observable<Apolice[]> {
    return <Observable<Apolice[]>>this.http.get(
      this.URL);
  }

  salvar(apolice: Apolice): Observable<Apolice> {
    if(apolice.id) {
      return <Observable<Apolice>>this.http.patch(
        this.URL, apolice);  
    }
    else {
      return <Observable<Apolice>>this.http.post(
        this.URL, apolice);
    }
  }

  remover(apolice: Apolice): Observable<any> {
    return <Observable<any>>this.http.delete(
      this.URL + '/' + apolice.id);
  }

  pesquisarPorPlaca(placa: string):  Observable<Apolice> {
    return <Observable<Apolice>>this.http.get(
      this.URL + '/placa/' + placa);
  }

  pesquisarPorNumero(numero: string):  Observable<Apolice> {
    console.log(numero);
    return <Observable<Apolice>>this.http.get(
      this.URL + '/numero/' + numero);
  }
}
