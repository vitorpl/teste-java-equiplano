import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApoliceComponent } from '../apolice/apolice.component';
import { ClienteComponent } from '../cliente/cliente.component';
import { PaginaNaoEncontradaComponent } from '../pagina-nao-encontrada/pagina-nao-encontrada.component';
import { PrincipalComponent } from '../principal/principal.component';


const routes: Routes = [
  { path: 'cadastroCliente', component: ClienteComponent },
  { path: 'cadastroApolice', component: ApoliceComponent },
  { path: 'principal', component: PrincipalComponent },
  { path: '',   redirectTo: '/principal', pathMatch: 'full' }, // redirect to `first-component`
  { path: '**', component: PaginaNaoEncontradaComponent },  // Wildcard route for a 404 page
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class RoutingModule { }
