import { Component, OnInit } from '@angular/core';
import {LoginService } from 'src/app/services/login.service';

import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  isLogget : boolean;

  constructor(private services: LoginService, private router: Router){
    this.isLogget = this.services.isLogget;
  }

  title = 'Proyecto';

  ngOnInit(){
    
  }

  cerrarSesion(){
    this.services.isLogget = true;
    this.router.navigate(['/inicio']);
  }

}

