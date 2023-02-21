import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usuario } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  URL = 'http://localhost8080/usuarios/';  

  constructor(private http: HttpClient) { }
public getUsuario(): Observable<usuario>{
  return this.http.get<usuario>(this.URL + '/traer');
}
}
