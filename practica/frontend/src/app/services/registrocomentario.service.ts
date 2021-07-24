import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class RegistroComentarioService {

  constructor(private _http: HttpClient) { }

  registrarComentario = (Comentario: any) => {
    return this._http.post(`${environment.API_URL}/registroComentario`, Comentario);
  }
  
}
