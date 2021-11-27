import { Component, OnInit } from '@angular/core';
import { CentrosService } from 'src/app/services/centros.service'; 
import { Centros } from 'src/app/model/centros';
import { Router } from '@angular/router';
import { Email } from 'src/app/model/email';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/model/usuario';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-peticiones',
  templateUrl: './peticiones.component.html',
  styleUrls: ['./peticiones.component.css']
})
export class PeticionesComponent implements OnInit {

  centro : Centros[];
  centroEdit : Centros = new Centros();
  mail : Email = new Email()
  id : string;
  correos : Usuario[];
  constructor(private router: Router,private service: CentrosService, private serviceUs: UsuarioService) { }

  ngOnInit(): void {
    this.service.getEstados("pendiente").subscribe(data=>[this.centro=data]);
  }

  aceptar(id: string, nombre: string,correo: string,descripcion: string,direccion: string){
    this.id = id;
    this.centroEdit.estado = "aceptado";
    this.centroEdit.descripcion = descripcion;
    this.centroEdit.direccion = direccion;
    this.centroEdit.nombre = nombre;
    this.centroEdit.correo = correo;
    console.log(id);
    
    this.service.updateEstado(this.id,this.centroEdit).subscribe();
    this.mail.mailSubject = "El punto "+ nombre+" fue aceptado!"
    this.mail.mailContent = "Hemos aceptado tu propuesta de punto de reciclaje, entra al sitio para visualizarla"
    this.mail.mailTo = correo;
    console.log(this.mail);
    this.service.enviarMail(this.mail).subscribe();

    //this.serviceUs.getAll().subscribe(data=>[this.correos=data]);
    //console.log(this.correos);


  }

  rechazar(id: string, nombre: string,correo: string,descripcion: string,direccion: string){
    this.id = id;
    this.centroEdit.estado = "rechazado";
    this.centroEdit.descripcion = descripcion;
    this.centroEdit.direccion = direccion;
    this.centroEdit.nombre = nombre;
    this.centroEdit.correo = correo;
    console.log(id);
    
    this.service.updateEstado(this.id,this.centroEdit).subscribe();
    this.mail.mailSubject = "El punto "+ nombre+" fue rechazado :("
    this.mail.mailContent = "Hemos rechazado tu propuesta de punto de reciclaje"
    this.mail.mailTo = correo;
    console.log(this.mail);
    this.service.enviarMail(this.mail).subscribe();

  }

}
