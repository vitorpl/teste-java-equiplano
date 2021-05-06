import { Estado } from './../model/estado';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  private readonly URL = 'http://localhost:8080/api/estados';

  constructor(private http: HttpClient) { }

  listar(): Observable<Estado[]> {
    return <Observable<Estado[]>>this.http.get(
      this.URL);
  }

}
