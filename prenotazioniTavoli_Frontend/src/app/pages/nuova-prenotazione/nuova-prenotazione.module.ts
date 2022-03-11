import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NuovaPrenotazionePageRoutingModule } from './nuova-prenotazione-routing.module';

import { NuovaPrenotazionePage } from './nuova-prenotazione.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NuovaPrenotazionePageRoutingModule
  ],
  declarations: [NuovaPrenotazionePage]
})
export class NuovaPrenotazionePageModule {}
