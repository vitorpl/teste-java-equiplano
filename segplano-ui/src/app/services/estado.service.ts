import { Estado } from './../model/estado';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Util } from '../util/util';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  private readonly URL = Util.getBaseUrl()+'api/estados';

  constructor(private http: HttpClient) { }

  listar(): Observable<Estado[]> {
    return <Observable<Estado[]>>this.http.get(
      this.URL);
  }

}
