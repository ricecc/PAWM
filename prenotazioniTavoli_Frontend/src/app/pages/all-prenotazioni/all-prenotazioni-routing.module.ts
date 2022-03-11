import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AllPrenotazioniPage } from './all-prenotazioni.page';

const routes: Routes = [
  {
    path: '',
    component: AllPrenotazioniPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AllPrenotazioniPageRoutingModule {}
