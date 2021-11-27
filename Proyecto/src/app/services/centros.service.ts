import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Centros } from '../model/centros';
import { Email } from '../model/email';
@Injectable({
  providedIn: 'root'
})
export class CentrosService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Centros[]> {
    return this.http.get<Centros[]>('http://localhost:8080/proyect/centroReciclaje/obtenerDatos');
  }

  get(id: String): Observable<Centros> {
    return this.http.get<Centros>(`http://localhost:8080/proyect/centroReciclaje/obtenerDato/${id}`);
  }

  create(centros: Centros){
    return this.http.post<Centros[]>('http://localhost:8080/proyect/centroReciclaje/envioDato', centros);
  }
  
  update(id: string, centros: Centros) {
    return this.http.put(`http://localhost:8080/proyect/centroReciclaje/actualizarDato/${id}`, centros);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`http://localhost:8080/proyect/centroReciclaje/eliminarDato/${id}`);
  }

  updateEstado(id: string, centros: Centros) {
    return this.http.put(`http://localhost:8080/proyect/centroReciclaje/actualizarEstado/${id}`, centros);
  }
  
  enviarMail(mail: Email){
    return this.http.post<Email>(`http://localhost:8080/proyect/centroReciclaje/enviarMail`, mail);
  }

  getEstados(estado: String): Observable<Centros[]> {
    return this.http.get<Centros[]>(`http://localhost:8080/proyect/centroReciclaje/obtenerDatosEstados/${estado}`);
  }

}
