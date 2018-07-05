import {LoginService} from '../../services/login.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-platform',
  templateUrl: './home-platform.component.html',
  styleUrls: ['./home-platform.component.css']
})
export class HomePlatformComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {
  }

  logout() {
    this.loginService.logOut();
    this.router.navigateByUrl("/login");
  }

}
