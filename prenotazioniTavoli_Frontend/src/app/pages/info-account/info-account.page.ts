import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cliente } from 'src/app/cliente';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-info-account',
  templateUrl: './info-account.page.html',
  styleUrls: ['./info-account.page.scss'],
})
export class InfoAccountPage implements OnInit {
cliente: Cliente = new Cliente();
username: String;
  constructor(private route: ActivatedRoute,
              private clienteService: ClienteService) { }

  ngOnInit() {
    this.username = this.route.snapshot.params['username'];
    this.getClienteByUsername();
  }

  getClienteByUsername(){
    this.clienteService.getClienteByUsername(this.username).subscribe(cliente => {
      this.cliente = cliente;
    });
  }

}
