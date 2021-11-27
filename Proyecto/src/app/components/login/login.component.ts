import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor( private router: Router, private services: LoginService) { }

  ngOnInit(): void {
  }

  regresarInicio() {
   
      this.router.navigate(['/inicio']);
        
  }

  registro() {
   
    this.router.navigate(['/registro']);
      
}

centros() {
   
  this.router.navigate(['/usuarios']);
  this.services.isLogget = true;
    
}

}
