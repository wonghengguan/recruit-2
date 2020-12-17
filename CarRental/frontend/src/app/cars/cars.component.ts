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
  public maxPrice:any;
  public condition:any;
  public yearFrom:any;
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
    this.userId = this.cookieService.get("userId");
    this.showDetails = false;
    this.search();
  }

  search(){
    let carForm = {
    };

    this.loading$ = true;
    this.carService.getCarList(carForm).subscribe(res => {
        if (res != null) {
          this.recordList$ = res.list;
        } else {
          this.recordList$ = null;
        }
        this.loading$ = false;
      }
    );
    console.log(this.recordList$)
  }

  filter(){

    let formMaxPrice = this.maxPrice;
    if(formMaxPrice==undefined) {
      formMaxPrice=-1;
    }
    let formYearFrom = this.yearFrom;
    if(formYearFrom==undefined) {
      formYearFrom=-1;
    }
    let formCondition = this.condition;
    if(formCondition==undefined) {
      formCondition=-1;
    }
    let formBrandName = this.brandName;
    if(formBrandName==undefined) {
      formBrandName="";
    }
    let formModelName = this.modelName;
    if(formModelName==undefined){
      formModelName="";
    }

    let carForm = {
      brandName:formBrandName,
      modelName:formModelName,
      maxPrice:formMaxPrice,
      yearFrom:formYearFrom,
      condition:formCondition,
      sort:this.sortType
    };

    this.loading$ = true;
    this.carService.getCarListByFilter(carForm).subscribe(res => {
        if (res != null) {
          this.recordList$ = res.list;
        } else {
          this.recordList$ = null;
        }
        this.loading$ = false;
      }
    );
    console.log(this.recordList$)
  }

  doSort(){
    this.filter();
  }

  rent(carId){
    let userVehicleForm = {
      userId: this.userId,
      carId: carId
    }
    this.userVehicleService.rentCar(userVehicleForm).subscribe( res => {
        if(res != null) {
          this.recordList$ = res.list;
        } else {
          this.recordList$ = null;
        }
      this.loading$ = false;
      }
    )
  }

  backToHome() {
    this.router.navigate(['/home']);
  }

}
