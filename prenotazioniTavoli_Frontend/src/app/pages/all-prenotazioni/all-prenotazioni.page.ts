import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Prenotazione } from 'src/app/prenotazione';
import { PrenotazioneService } from 'src/app/service/prenotazione.service';

@Component({
  selector: 'app-all-prenotazioni',
  templateUrl: './all-prenotazioni.page.html',
  styleUrls: ['./all-prenotazioni.page.scss'],
})
export class AllPrenotazioniPage implements OnInit {

  prenotazioni: Prenotazione[];
  usernameCliente: string;
  constructor(private route: ActivatedRoute,
              private prenotazioniService: PrenotazioneService) { }

  ngOnInit() {
    this.usernameCliente = this.route.snapshot.params['username'];
    this.getAllPrenotazioni();
  }

  getAllPrenotazioni(){
    this.prenotazioniService.getAllPrenotazioniByUsernameCliente(this.usernameCliente).subscribe(
      data =>{
        this.prenotazioni = data;
      }
    );
  }

  cancella(idPrenotazione: number){
      this.prenotazioniService.deletePrenotazione(idPrenotazione).subscribe(data =>{
        this.getAllPrenotazioni();
      });
  }
}
