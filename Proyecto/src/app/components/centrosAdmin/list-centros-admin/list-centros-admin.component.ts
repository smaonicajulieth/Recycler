import { Component, OnInit } from '@angular/core';
import { CentrosService } from 'src/app/services/centros.service';
import { Centros } from 'src/app/model/centros';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-centros-admin',
  templateUrl: './list-centros-admin.component.html',
  styleUrls: ['./list-centros-admin.component.css']
})
export class ListCentrosAdminComponent implements OnInit {

  centro : Centros[];
  constructor(private router: Router,private service: CentrosService) { }
  
  ngOnInit(): void {

    this.service.getEstados("aceptado").subscribe(data=>[this.centro=data]);
  }

  Eliminar(id:string){
    console.log(id);
    this.service.delete(id).subscribe();
    this.router.navigate(['/listCentrosAdmin']);
    window.location.reload();
  }

}
