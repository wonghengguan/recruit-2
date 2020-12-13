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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService,AppConfig,ApiRequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
