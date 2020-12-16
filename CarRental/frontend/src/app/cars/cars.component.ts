import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {AppConfig} from "../app-config";
import {CarService} from "../services/car/car-service";
import {CookieService} from "ngx-cookie-service";
import {UserService} from "../services/user/user-service";
import {Router} from "@angular/router";
import {UserVehicleService} from "../services/uservehicle/uservehicle-service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit {

  public userId:any;
  public user:any;

  //Search
  public brandName:any;
  public modelName:any;
  public price:any;
  public condition:any;
  public year:any;
  public loading$:any;

  public recordList$:any;

  //Sort
  public sortType:any= '0';

  //View Details
  showDetails;
  object: any;

  constructor(private titleService: Title,
              private cookieService: CookieService,
              private router: Router,
              private userVehicleService: UserVehicleService,
              private userService: UserService,
              private carService: CarService) {
    this.titleService.setTitle("Car rental | Car list");

  }

  ngOnInit() {
    this.showDetails = false;
    this.search();
  }

  search(){
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

    let carForm = {
      brandName:'Mazda'
    };

    this.loading$ = true;
    this.carService.getCarList(carForm).subscribe(res => {
        if (res != null) {
          this.recordList$ = res.list;
        }
        this.loading$ = false;
      }
    );
  }

  doSort(){
    this.search();
  }

  rent(carId){
    let userVehicleForm = {
      userId: this.userId,
      carId: carId
    }
    this.userVehicleService.rentCar(userVehicleForm).subscribe( res => {
        if(res != null) {
          this.recordList$ = res.list;
        }
      this.loading$ = false;
      }
    )
  }

  backToHome() {
    this.router.navigate(['/home']);
  }
}
