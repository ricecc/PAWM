import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss'],
})
export class NavBarComponent implements OnInit {
username: any;
public loggedIn=false;

tokenFileds = {
  token:''
}
  constructor(private loginService: LoginService, private tokenService: TokenService) { }

  ngOnInit() {
    this.loggedIn = this.loginService.isLoggedIn();
    if(this.loggedIn){
      this.tokenFileds.token = this.tokenService.getToken();
      this.getUsernameByToken();
    }
  }

  logoutUser(){
    this.loginService.logout()
    location.reload();
  }

  getUsernameByToken(){
    this.tokenService.getUsernameByToken(this.tokenFileds).subscribe(
      (response:any) => {
      this.username = response.username;
    });
  }
}
