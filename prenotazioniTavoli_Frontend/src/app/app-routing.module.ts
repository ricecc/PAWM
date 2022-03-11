import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './service/auth.guard';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: ' ',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'info-account',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'all-prenotazioni',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'nuova-prenotazione',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login-page',
    loadChildren: () => import('./pages/login-page/login-page.module').then( m => m.LoginPagePageModule)
  },
  {
    path: 'registrazione',
    loadChildren: () => import('./pages/registrazione/registrazione.module').then( m => m.RegistrazionePageModule)
  },
  {
    path: 'all-prenotazioni/:username',
    loadChildren: () => import('./pages/all-prenotazioni/all-prenotazioni.module').then( m => m.AllPrenotazioniPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'dashboard/:username',
    loadChildren: () => import('./pages/dashboard/dashboard.module').then( m => m.DashboardPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'info-account/:username',
    loadChildren: () => import('./pages/info-account/info-account.module').then( m => m.InfoAccountPageModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'nuova-prenotazione/:username/:ristorante',
    loadChildren: () => import('./pages/nuova-prenotazione/nuova-prenotazione.module').then( m => m.NuovaPrenotazionePageModule),
    canActivate:[AuthGuard]
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
