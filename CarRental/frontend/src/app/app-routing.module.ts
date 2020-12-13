import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";


const routes: Routes = [
  {
    path: '', component: LoginComponent, data: { title: 'Car rental - Login' }
  },
  {
    path: '#/**', component: LoginComponent, data: { title: 'Car rental - Login' }
  },
  {
    path: 'login', component: LoginComponent, data: { title: 'Car rental - Login' }
  },
  {
    path: 'home', component: HomeComponent, data: { title: 'Home' }
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
