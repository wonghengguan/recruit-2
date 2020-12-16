import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import {ApiRequestService} from "../ApiRequestService";

@Injectable()
export class UserVehicleService {
  constructor(private router: Router,
              private apiService: ApiRequestService) {}

  getUserVehicleList(body) {
    return this.apiService.post("api/uservehicle/getuservehiclelist", body);
  }

  returnCar(body) {
    return this.apiService.post("api/uservehicle/returnvehicle", body);
  }

  rentCar(body) {
    return this.apiService.post("api/uservehicle/rentvehicle", body);
  }
}
