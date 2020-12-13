import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import {ApiRequestService} from "../ApiRequestService";

@Injectable()
export class UserService {
  constructor(private router: Router,
              private apiService: ApiRequestService) {}

  login(body) {
    return this.apiService.post("api/user/login", body);
  }

  logout() {
    this.router.navigate(['/login']);
  }
}
