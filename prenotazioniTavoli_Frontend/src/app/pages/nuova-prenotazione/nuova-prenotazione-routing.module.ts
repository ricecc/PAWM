import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuovaPrenotazionePage } from './nuova-prenotazione.page';

const routes: Routes = [
  {
    path: '',
    component: NuovaPrenotazionePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuovaPrenotazionePageRoutingModule {}
