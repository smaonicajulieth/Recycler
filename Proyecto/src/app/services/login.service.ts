import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLogget : boolean;

  constructor() {
    this.isLoggetIn();
   }

  isLoggetIn(){
    
    this.isLogget = localStorage.getItem("isLogget")?true:false;
   
  }


}
