import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user/user-service";
import {Router} from "@angular/router";
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public username: any;
  public password: any;
  public errorMsg: any;

  constructor(private router: Router,
              private cookieService: CookieService,
              private userService: UserService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.errorMsg = undefined;

    if (this.username == undefined || this.username == '') {
      this.errorMsg = 'please enter username.';
      return;
    }

    if (this.password == undefined || this.password == '') {
      this.errorMsg = 'please enter password.';
      return;
    }

      let form = {
        username: this.username,
        password: this.password
      };

      this.userService.login(form).subscribe(data => {
        if (data == null) {
            this.errorMsg = 'User not found!';
        } else if (data != null) {
          this.cookieService.set("userId", data, 30,"/");
          this.router.navigate(['/home']);
        }
      });
    }

}
