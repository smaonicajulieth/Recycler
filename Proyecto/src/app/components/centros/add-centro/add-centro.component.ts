import Swal from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Centros } from 'src/app/model/centros';
import { NgForm } from '@angular/forms';
import { Email } from 'src/app/model/email';
import { CentrosService } from 'src/app/services/centros.service';

@Component({
  selector: 'app-add-centro',
  templateUrl: './add-centro.component.html',
  styleUrls: ['./add-centro.component.css']
})
export class AddCentroComponent implements OnInit {

  centro : Centros = new Centros();
  email : Email = new Email();
  estado = "pendiente";

  constructor(private router: Router,private service: CentrosService) { }

  ngOnInit(): void {
  }

  onFormSubmit(form : NgForm){
    this.centro.nombre = form.value.nombre;
    this.centro.descripcion = form.value.descripcion;
    this.centro.direccion = form.value.direccion;
    this.centro.correo = form.value.correo;
    this.centro.estado = this.estado;

    this.service.create(this.centro).subscribe();

    /*
    this.email.mailTo = "j.mateo25082000@gmail.com";
    this.email.mailSubject = "Nueva Solicitud centro de reciclaje" + form.value.nombre;
    this.email.mailContent = "Hay una nueva solicitud para un punto de reciclaje";

    this.service.correo(this.email).subscribe();*/
    
    Swal.fire({
      icon: 'success',
      title: 'Registrado',
      confirmButtonText: `OK`,
      text: '¡Hemos enviado el punto! Estara bajo revision'
    }).then((result) =>{
      if(result.isConfirmed){
        this.router.navigate(['listCentro'])
      }
    })
    
  }

}
