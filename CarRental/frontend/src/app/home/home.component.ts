import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CookieService} from "ngx-cookie-service";
import {UserService} from "../services/user/user-service";
import {UserVehicleService} from "../services/uservehicle/uservehicle-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public userId:any;
  public user:any;
  public userVehicleList:any;

  constructor(private titleService: Title,
              private router: Router,
              private cookieService: CookieService,
              private userVehicleService: UserVehicleService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.getUser();
    this.getUserVehicle();
  }

  getUser() {
    this.userId = this.cookieService.get("userId");

    let userForm = {
      id:this.userId,
    }
    this.userService.getUser(userForm).subscribe( res => {
        if(res != null){
          this.user=res;
        } else {
          console.log("cannot get user");
        }
      }
    )
  }

  getUserVehicle() {
    let userVehicleForm = {
      userId:this.userId
    }
    this.userVehicleService.getUserVehicleList(userVehicleForm).subscribe( res => {
          if(res != null) {
            this.userVehicleList=res;
        } else {
            this.userVehicleList=null;
          }
      }
    )
  }

  return(carId) {
    let userVehicleForm = {
      userId: this.userId,
      carId: carId
    }
    this.userVehicleService.returnCar(userVehicleForm).subscribe( res => {
        if(res != null) {
          this.userVehicleList=res;
        } else {
          this.userVehicleList=null;
        }
      }
    )
  }

  proceedToCarList() {
    this.router.navigate(['/cars']);
  }

  logout() {
    this.cookieService.delete("userId");
    this.router.navigate(['']);
  }
}
