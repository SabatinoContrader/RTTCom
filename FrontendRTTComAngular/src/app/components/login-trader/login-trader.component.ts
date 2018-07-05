import {Utente} from '../../models/utente.model';
import {LoginService} from '../../services/login.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-trader',
  templateUrl: './login-trader.component.html',
  styleUrls: ['./login-trader.component.css']
})

export class LoginTraderComponent implements OnInit {
  username: string;
  password: string;
  utente: Utente;

  constructor(private loginservice: LoginService, private router: Router) {}

  ngOnInit() {
    if (this.loginservice.isLogged()) {
      this.router.navigate(['home']);
    }
  }

  login(): void {
    this.loginservice.login(this.username, this.password).subscribe((response) => {
      if (response != null) {
        this.utente = response;
        sessionStorage.setItem("utente", JSON.stringify(this.utente));
        this.router.navigateByUrl("/home");
      }
    });
  }

}
