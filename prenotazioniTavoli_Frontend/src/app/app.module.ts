import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { JwtHelperService,JWT_OPTIONS } from '@auth0/angular-jwt';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginService } from './service/login.service';
import { AuthGuard } from './service/auth.guard';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './service/auth.interceptor';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent,NavBarComponent],
  entryComponents: [],
  imports: [BrowserModule,
     IonicModule.forRoot(), 
     AppRoutingModule,
     FormsModule,
    HttpClientModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }, 
                LoginService,
                AuthGuard,
                [{provide:HTTP_INTERCEPTORS, useClass: AuthInterceptor,multi:true}],
                [{ provide: JWT_OPTIONS, useValue: JWT_OPTIONS },JwtHelperService]],
  bootstrap: [AppComponent],
})
export class AppModule {}
