import {HomePlatformComponent} from './components/home-platform/home-platform.component';
import { IuprodottiComponent } from './components/iuprodotti/iuprodotti.component';
import {LoginTraderComponent} from './components/login-trader/login-trader.component';
import { ProdottiComponent } from './components/prodotti/prodotti.component';
import { RegisterComponent } from './components/register/register.component';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginTraderComponent},
  {path: 'home', component: HomePlatformComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'prodotti', component: ProdottiComponent},
  {path: 'backLogin', component: RegisterComponent},
  {path: 'iuprodotti', component: IuprodottiComponent}
];


@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes, {useHash: true})]
})
export class AppRoutingModule {}
