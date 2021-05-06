import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../model/cliente';
import { Util } from '../util/util';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private readonly URL = Util.getBaseUrl()+'api/clientes';

  constructor(private http: HttpClient) { }

  listar(): Observable<Cliente[]> {
    return <Observable<Cliente[]>>this.http.get(
      this.URL);
  }

  salvar(cliente: Cliente): Observable<Cliente> {
    if(cliente.id) {
      return <Observable<Cliente>>this.http.patch(
        this.URL, cliente);  
    }
    else {
      return <Observable<Cliente>>this.http.post(
        this.URL, cliente);
    }
  }

  remover(cliente: Cliente): Observable<any> {
    return <Observable<any>>this.http.delete(
      this.URL + '/' +cliente.id);
  }
}
