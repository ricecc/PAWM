import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { TokenService } from 'src/app/service/token.service';
import { AlertController } from '@ionic/angular';
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.page.html',
  styleUrls: ['./login-page.page.scss'],
})
export class LoginPagePage implements OnInit {

  credentials={
    username:'',
    password:''
  }
  constructor(private tokenService: TokenService, 
              private loginService: LoginService,
              private alertCtrl: AlertController) { }

  ngOnInit() {
  }


  onSubmit(){
    console.log("form is submitted");
    if((this.credentials.username!='' && this.credentials.password!='')
    &&(this.credentials.username!=null && this.credentials.password!=null)){
      console.log("we have to submit the form to serve");
      //token generate
      this.tokenService.generateLoginToken(this.credentials).subscribe(
        (response:any)=>{
          //success
          console.log("Token:" + response.token);
          console.log("Username:" + response.username);
          this.loginService.loginUser(response.token)
          window.location.href="/dashboard/"+response.username;
        }, error=>{
            console.log(error);
            this.showAlertBadCredentials()
        }
      )
 
    }else{
     this.showAlertEmpltyField();
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

   async showAlertBadCredentials(){
    const alert = await this.alertCtrl.create({
         header: 'Ops!',
         message: 'Utente non trovato',
         buttons: ['ok']
    })
    
    await alert.present();
   }
   
}
