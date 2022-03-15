import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";
import { TokenService } from "./token.service";
import { JwtHelperService } from "@auth0/angular-jwt";
@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    constructor(private tokenService: TokenService,private jwtHelper: JwtHelperService, private loginService: LoginService){}
    intercept(req: HttpRequest<any>, next: HttpHandler):Observable<HttpEvent<any>> {
        
        let newReq = req;
        let token = this.tokenService.getToken();

        if(this.jwtHelper.isTokenExpired(token)){
            localStorage.removeItem("token");
            this.loginService.logout();
            newReq = newReq.clone({setHeaders:{}});
          } else if(token != null){
           newReq = newReq.clone({setHeaders:{Authorization:`Bearer ${token}`}})  
        }

        return next.handle(newReq)
         
    }
}