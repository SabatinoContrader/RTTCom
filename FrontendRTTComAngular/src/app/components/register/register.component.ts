import {Utente} from '../../models/utente.model';
import {RegisterService} from '../../services/register.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  id: number;
  username: string;
  password: string;
  nome: string;
  cognome: string;
  utente: Utente;

  constructor(private registerService: RegisterService, private router: Router) {}

  ngOnInit() {
  }


  insertUtente() {
    this.registerService.insertUtente(this.username, this.password, this.nome, this.cognome).subscribe((response) => {
      this.utente = response;
      this.router.navigateByUrl("/login");

    });
  }
}
