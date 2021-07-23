import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {

  constructor(private _http: HttpClient) { }

  listarComentarios = () =>{
    return this._http.get<any>(`${environment.API_URL}/listarComentario`)
  }
}
