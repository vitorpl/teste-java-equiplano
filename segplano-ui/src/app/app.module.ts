import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import localePt from '@angular/common/locales/pt';
import { AppComponent } from './app.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ApoliceComponent } from './apolice/apolice.component';
import { PrincipalComponent } from './principal/principal.component';

import { RouterModule } from '@angular/router';
import { RoutingModule } from './routing/routing.module';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { registerLocaleData } from '@angular/common';
import { DadosApoliceComponent } from './dados-apolice/dados-apolice.component';


registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    ApoliceComponent,
    PrincipalComponent,
    PaginaNaoEncontradaComponent,
    DadosApoliceComponent
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pt-BR'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
