import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.page.html',
  styleUrls: ['./registrazione.page.scss'],
})
export class RegistrazionePage implements OnInit {

newCliente = {
  nome:'',
  cognome: '',
  email: '',
  citta: '',
  password: '',
  username: '',
  rol: 'cliente'
}

  constructor(private tokenService: TokenService) { }

  ngOnInit() {
  }

  onSubmit(){
    this.tokenService.saveUser(this.newCliente).subscribe(data =>{
      window.location.href="/login-page";
    })
  }

}
