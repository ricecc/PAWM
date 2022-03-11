import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ristorante } from '../ristorante';

@Injectable({
  providedIn: 'root'
})
export class RistoranteService {
  url="http://localhost:8080/app"
  constructor(private http:HttpClient) { }


  getResturantByCity(citta: String):Observable<Ristorante[]>{
    return this.http.get<Ristorante[]>(`${this.url}/getResturantByCity/${citta}`);
  }

  getResturantByNome(nome:String):Observable<Ristorante>{
    return this.http.get<Ristorante>(`${this.url}/getRistoranteByNome/${nome}`);
  }



}
