import {Prodotto} from '../models/prodotto.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProdottiService {

  constructor(private http: HttpClient) {}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  listaprodotti(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/prodotto/ritornaProdotti')
      //return this.http.get<any>('http://localhost:8080/prodotto/ritornaProdotti', null)
      .pipe(tap((response) => console.log("Prodotto"), catchError(this.handleError("login error", {})))
      );
  }

  insertprodotti(id: number, ean: string, category: string, model: string, manufacturer: string,
    description: string, longDescription: string, sellPrice: number): Observable<Prodotto> {
    var formdata = new FormData();
    var newProdotto = new Prodotto(0, ean, category, model, manufacturer, description, longDescription, sellPrice);
    return this.http.post<Prodotto>('http://localhost:8080/prodotto/insertProdotto', newProdotto)
      .pipe(tap((response) => console.log("insert"), catchError(this.handleError("insert prodotto error", {})))
      );
  }

  deleteProduct(idDelete: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/prodotto/EliminaProdotto?id=' + idDelete)
      //return this.http.get<any>('http://localhost:8080/prodotto/ritornaProdotti', null)
      .pipe(tap((response) => console.log("deleteProduct"), catchError(this.handleError("delete error", {})))
      );
  }

}
