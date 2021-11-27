import { Component, OnInit } from '@angular/core';
import { CentrosService } from 'src/app/services/centros.service';
import { Centros } from 'src/app/model/centros';
import { Router } from '@angular/router';
import { NgLocaleLocalization } from '@angular/common';
@Component({
  selector: 'app-list-centros',
  templateUrl: './list-centros.component.html',
  styleUrls: ['./list-centros.component.css']
})
export class ListCentrosComponent implements OnInit {

  centro : Centros[];
  constructor(private router: Router,private service: CentrosService) { }
  
  ngOnInit(): void {

    this.service.getEstados("aceptado").subscribe(data=>[this.centro=data]);
  }


}
