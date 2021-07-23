import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})

export class RegistroService {

  constructor(private _http: HttpClient) { }

  registrarUsuario = (usuario: any) => {
    return this._http.post(`${environment.API_URL}/postUser`, usuario);
  }

}
