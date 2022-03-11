import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  url="http://localhost:8080"
  constructor(private http:HttpClient) { }

  generateLoginToken(credentials:any){
    //token generate      
    return this.http.post(`${this.url}/tokenLogin`,credentials)
  }

  saveUser(credentials:any){
    
    return this.http.post(`${this.url}/tokenInsertCliente`,credentials)
  }

  savePrenotazione(credentials:any){
         
    return this.http.post(`${this.url}/tokenInsertPrenotazione`,credentials)
  }

  getUsernameByToken(token:any){
    return this.http.post(`${this.url}/getUsernameByToken`,token)
  }

  getToken(){
    return localStorage.getItem("token");
  }




}
