import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AllPrenotazioniPageRoutingModule } from './all-prenotazioni-routing.module';

import { AllPrenotazioniPage } from './all-prenotazioni.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AllPrenotazioniPageRoutingModule
  ],
  declarations: [AllPrenotazioniPage]
})
export class AllPrenotazioniPageModule {}
