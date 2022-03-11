import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Prenotazione } from '../prenotazione';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {
  url="http://localhost:8080/app"
  constructor(private http:HttpClient) { }


  getAllPrenotazioniByUsernameCliente(username: String):Observable<Prenotazione[]>{
    return this.http.get<Prenotazione[]>(`${this.url}/prenotazioni/cliente/${username}`);
  }

  deletePrenotazione(idPrenotazione: number){
    return this.http.delete(`${this.url}/deleteprenotazione/${idPrenotazione}`);
  }
}
