import {Injectable} from "@angular/core";
import {ApiRequestService} from "../ApiRequestService";
import {Observable} from "rxjs";

@Injectable()
export class CarService {
  constructor(
    private apiRequest: ApiRequestService
  ) { }

  getCarList(form): Observable<any> {
    return Observable.create(observer => {
      this.apiRequest.post('api/cars/getCarList', form)
        .subscribe(
          res => {
            observer.next(res);
          }, err => {
            observer.error(err);
          }
        )
    });
  }
}
