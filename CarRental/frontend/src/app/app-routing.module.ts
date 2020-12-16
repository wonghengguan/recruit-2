import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {CarsComponent} from "./cars/cars.component";


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
    path: 'home', component: HomeComponent, data: { title: 'Car rental - Home' }
  },
  {
    path: 'cars', component: CarsComponent, data: { title: 'Car rental - Available cars' }
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
