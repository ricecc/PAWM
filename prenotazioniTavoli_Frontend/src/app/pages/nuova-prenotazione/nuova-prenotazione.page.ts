import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-nuova-prenotazione',
  templateUrl: './nuova-prenotazione.page.html',
  styleUrls: ['./nuova-prenotazione.page.scss'],
})
export class NuovaPrenotazionePage implements OnInit {
prenotazione = {
  nome:'',
  numGuest: '',
  dataPrenotazione:'',
  start:'',
  usernameCliente: '',
  nomeRistorante: '',
}

usernameCliente:string;
nomeRistornate: string;
  constructor( private route: ActivatedRoute,
               private tokenService: TokenService,
               private alertCtrl: AlertController) { }

  ngOnInit() {
    this.usernameCliente = this.route.snapshot.params['username'];
    this.nomeRistornate = this.route.snapshot.params['ristorante']
    this.prenotazione.usernameCliente = this.usernameCliente;
    this.prenotazione.nomeRistorante = this.nomeRistornate;
  }

  onSubmit(){
    if((this.prenotazione.nome != '' && this.prenotazione.nomeRistorante != '' 
        && this.prenotazione.numGuest != ''  && this.prenotazione.start != '') 
                                        && 
        (this.prenotazione.nome != null && this.prenotazione.nomeRistorante != null 
        && this.prenotazione.numGuest != null  && this.prenotazione.start != null))
        
        {
            this.tokenService.savePrenotazione(this.prenotazione).subscribe(
              data =>{
                window.location.href="/all-prenotazioni/"+this.usernameCliente;
              }
            );
      }else{
        this.showAlertEmpltyField()
      }
    }

    async showAlertEmpltyField(){
      const alert = await this.alertCtrl.create({
           header: 'Ops!',
           message: 'Compila tutti i campi',
           buttons: ['ok']
      })
      
      await alert.present();
     }
}
