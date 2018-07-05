import {enviroment} from '../models/enviroment.model';
import {Utente} from '../models/utente.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {Observable, of} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';

@Injectable()
export class LoginService {
  private urlBase = enviroment.url;

  constructor(private http: HttpClient) {}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);
      console.log('${operation} failed: ${error.message}');

      return of(result as T);
    };
  }

  isLogged(): boolean {
    if (typeof (Storage) !== "undefined") {
      if (sessionStorage.getItem("utente") != null) {
        return true;
      }
    } return false;
  }

  login(username: string, password: string): Observable<Utente> {
    var utente = new Utente(0, username, password, " ", " ");
    return this.http.post<Utente>('http://localhost:8080/login/logintraderControl', utente)
      .pipe(tap((response) => console.log("Utente"), catchError(this.handleError("login error", {})))
      );
  }

  logOut() {
    if (typeof (Storage) !== "undefined") {
      //sessionStorage.setItem("utente", null);
      // sessionStorage.clear();
      sessionStorage.removeItem("utente");
    }
  }
}
