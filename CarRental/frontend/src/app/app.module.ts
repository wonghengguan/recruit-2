import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {UserService} from "./services/user/user-service";
import {AppConfig} from "./app-config";
import {ApiRequestService} from "./services/ApiRequestService";
import { HttpClientModule, HttpClient } from "@angular/common/http";
import { CarsComponent } from './cars/cars.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CarService} from "./services/car/car-service";
import {UserVehicleService} from "./services/uservehicle/uservehicle-service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CarsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [UserService,AppConfig,ApiRequestService,CarService,UserVehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
