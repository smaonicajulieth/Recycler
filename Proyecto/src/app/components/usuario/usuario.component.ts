import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    
  }

  mostrar(){  
    this.router.navigate(['addCentro']);
  }

}
