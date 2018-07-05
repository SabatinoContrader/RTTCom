import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {IntestazioneComponent} from './components/intestazione/intestazione.component';
import {LoginTraderComponent} from './components/login-trader/login-trader.component';
import {FooterComponent} from './components/footer/footer.component';
import {UtenteComponent} from './components/utente/utente.component';
import {HttpClientModule} from '@angular/common/Http';
import {HomePlatformComponent} from './components/home-platform/home-platform.component';
import {LoginService} from './services/login.service';
import {RegisterComponent} from './components/register/register.component';
import {RegisterService} from './services/register.service';
import {ProdottiComponent} from './components/prodotti/prodotti.component';
import {ProdottiService} from './services/prodotti.service';
import {IuprodottiComponent} from './components/iuprodotti/iuprodotti.component';

@NgModule({
  declarations: [
    AppComponent,
    IntestazioneComponent,
    LoginTraderComponent,
    FooterComponent,
    UtenteComponent,
    HomePlatformComponent,
    RegisterComponent,
    ProdottiComponent,
    IuprodottiComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [LoginService, RegisterService, ProdottiService],
  bootstrap: [AppComponent]
})
export class AppModule {}
