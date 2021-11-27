import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

const baseUrl = 'http://localhost:8080/proyect/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { 
  }

  getAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>('http://localhost:8080/proyect/usuario/obtenerDatos');
  }

  get(id: String): Observable<Usuario> {
    return this.http.get<Usuario>(`http://localhost:8080/proyect/usuario/obtenerDato/${id}`);
  }

  create(usuario: Usuario){
    return this.http.post<Usuario[]>('http://localhost:8080/proyect/usuario/envioDato', usuario);
  }
  
  update(id: string, usuario: Usuario) {
    return this.http.put(`http://localhost:8080/proyect/usuario/actualizarDato/${id}`, usuario);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`http://localhost:8080/proyect/usuario/eliminarDato/${id}`);
  }

  

 
}
