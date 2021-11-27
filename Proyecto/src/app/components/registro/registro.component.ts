import { Component, OnInit } from '@angular/core';
import  Swal  from 'sweetalert2';
import { Router, ActivatedRoute } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuario } from 'src/app/model/usuario';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  usuario : Usuario = new Usuario();
  constructor(private router: Router,private service: UsuarioService) { }

  ngOnInit(): void {
  }

  onFormSubmit(form : NgForm){
    this.usuario.userName = form.value.userName;
    this.usuario.correo = form.value.correo;
    this.usuario.password = form.value.password;
    this.usuario.active = true;
    this.usuario.roles = "ROLE_USER";
    this.service.create(this.usuario).subscribe();

    Swal.fire({
      icon: 'success',
      title: 'Usuario registrado',
      confirmButtonText: `OK`,
      text: 'El usuario ha sido registrado'
    }).then((result) =>{
      if(result.isConfirmed){
        this.router.navigate(['/login'])
      }
    })
  }

  regresarInicio() {
   
    this.router.navigate(['/inicio']);
      
}
}
