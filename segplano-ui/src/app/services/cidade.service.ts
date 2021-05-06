import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cidade } from '../model/cidade';
import { Estado } from '../model/estado';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  private readonly URL = 'http://localhost:8080/api/cidades';
  private readonly URL_LISTAR_POR_ESTADO = 'http://localhost:8080/api/cidades/estado';

  constructor(private http: HttpClient) { }

  listar(): Observable<Cidade[]> {
    return <Observable<Cidade[]>>this.http.get(
      this.URL);
  }

  listarPorEstado(estado: Estado): Observable<Cidade[]> {
    return this.listarPorIdEstado(estado.id);
  }

  listarPorIdEstado(idEstado: number): Observable<Cidade[]> {
    return <Observable<Cidade[]>>this.http.get(
      this.URL_LISTAR_POR_ESTADO + "/" + idEstado);
  }
}
