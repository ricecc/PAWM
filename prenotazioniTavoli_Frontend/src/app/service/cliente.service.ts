import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TouchSequence } from 'selenium-webdriver';
import { Cliente } from '../cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  url="http://localhost:8080/app"
  constructor(private http:HttpClient) { }

  getClienteByUsername(username: String):Observable<Cliente>{
    return this.http.get<Cliente>(`${this.url}/getCliente/${username}`);
  }
}
