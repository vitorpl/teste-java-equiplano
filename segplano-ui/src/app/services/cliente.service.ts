import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private readonly URL = 'http://localhost:8080/api/clientes';

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
