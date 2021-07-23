import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private _http: HttpClient) { }

  listarUsuarios = () => {
    // const testing = "soy testing";
    // console.log(testing);
    return this._http.get<any>(`${environment.API_URL}/listarUsuario`);
  }

  login(usuarios: any): Observable<any> {
    return this._http.post(`${environment.API_URL}/login`, usuarios); //API_URL
  }
}