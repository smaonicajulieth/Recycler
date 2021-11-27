import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCentroComponent } from './components/centros/add-centro/add-centro.component';
import { ListCentrosComponent } from './components/centros/list-centros/list-centros.component';
import { LoginComponent } from './components/login/login.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { RegistroComponent } from './components/registro/registro.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { AdminComponent } from './components/admin/admin.component';
import { PeticionesComponent } from './components/peticiones/peticiones.component';
import { ListCentrosAdminComponent } from './components/centrosAdmin/list-centros-admin/list-centros-admin.component';

const routes: Routes = [
  { path: 'addCentro', component: AddCentroComponent },
  { path: 'listCentro', component: ListCentrosComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'registro', component: RegistroComponent },
  { path: '', redirectTo: 'inicio', pathMatch: 'full'},
  { path: 'usuarios', component: UsuarioComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'peticiones', component: PeticionesComponent },
  { path: 'listCentrosAdmin', component: ListCentrosAdminComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
