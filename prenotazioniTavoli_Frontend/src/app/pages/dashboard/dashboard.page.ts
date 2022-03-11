import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { Cliente } from 'src/app/cliente';
import { Ristorante } from 'src/app/ristorante';
import { ClienteService } from 'src/app/service/cliente.service';
import { RistoranteService } from 'src/app/service/ristorante.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
})
export class DashboardPage implements OnInit {
username:String;
cittaCliente:String;
cliente: Cliente = new Cliente();
ristoranti: Ristorante[];

searchResturant:string;
checkResturant: boolean;

  constructor(private ristoranteService:RistoranteService,
              private router: Router ,
              private route: ActivatedRoute,
              private clienteService: ClienteService,
              private alertCtrl: AlertController) {
            
               }

  ngOnInit() {
    this.username = this.route.snapshot.params['username'];
    this.getCittaFromCliente();
  }

  getCittaFromCliente(){
  this.clienteService.getClienteByUsername(this.username).subscribe(cliente => {
    this.cittaCliente = cliente.citta;
    this.getAllResturantByCittaCliente();
  });
  }

getAllResturantByCittaCliente(){
  this.ristoranteService.getResturantByCity(this.cittaCliente).subscribe(
    (response: Ristorante[])=>{
        this.ristoranti = response;
    },
    (error: HttpErrorResponse) =>{
      alert(error.message)
    }
    );
}

  prenota(nomeRistorante: String){
      this.router.navigate(['nuova-prenotazione',this.username,nomeRistorante]);
  }


  nuovaPrenotazione(){
    this.getResturantByName();
  }

getResturantByName(){
  this.ristoranteService.getResturantByNome(this.searchResturant).subscribe(data =>{
    if(data != null){
      this.checkResturant = true;
      this.router.navigate(['nuova-prenotazione',this.username,this.searchResturant]);
    }else{
      this.checkResturant = false;
      this.showAlert();
    }
  });
}

async showAlert(){
 const alert = await this.alertCtrl.create({
      header: 'Ops!',
      message: 'Ristorante non presente, scgliene un altro',
      buttons: ['ok']
 })
 
 await alert.present();
}

}
