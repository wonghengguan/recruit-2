import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {AppConfig} from "../app-config";
import {CarService} from "../services/car/car-service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit {

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
              private carService: CarService) {
    this.titleService.setTitle("Car rental | Car list");

  }

  ngOnInit() {
    this.showDetails = false;
    this.search();
  }

  search(){
    let form = {
      brandName:'Mazda'
    };

    this.loading$ = true;
    this.carService.getCarList(form).subscribe(res => {
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

  rent(){

  }
}
