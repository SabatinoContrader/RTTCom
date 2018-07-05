import {Utente} from '../models/utente.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) {}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  insertUtente(username: string, password: string, nome: string, cognome: string): Observable<Utente> {
    var formdata = new FormData();
    var newUtente = new Utente(0, username, password, nome, cognome);
    return this.http.post<Utente>('http://localhost:8080/utente/registerControl', newUtente)
      .pipe(tap((response) => console.log("insert"), catchError(this.handleError("insert register error", {})))
      );
  }
}
