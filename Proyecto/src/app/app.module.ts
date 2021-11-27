import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AddCentroComponent } from './components/centros/add-centro/add-centro.component';
import { ListCentrosComponent } from './components/centros/list-centros/list-centros.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { RegistroComponent } from './components/registro/registro.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { AdminComponent } from './components/admin/admin.component';
import { PeticionesComponent } from './components/peticiones/peticiones.component';
import { ListCentrosAdminComponent } from './components/centrosAdmin/list-centros-admin/list-centros-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddCentroComponent,
    ListCentrosComponent,
    InicioComponent,
    RegistroComponent,
    UsuarioComponent,
    AdminComponent,
    PeticionesComponent,
    ListCentrosAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
