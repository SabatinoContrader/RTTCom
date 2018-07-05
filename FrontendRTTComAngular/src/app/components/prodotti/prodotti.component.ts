import {Prodotto} from '../../models/prodotto.model';
import {ProdottiService} from '../../services/prodotti.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-prodotti',
  templateUrl: './prodotti.component.html',
  styleUrls: ['./prodotti.component.css']
})
export class ProdottiComponent implements OnInit {
  listaProdotti: Prodotto[];
  idProdotto: number;

  constructor(private prodottiService: ProdottiService) {}

  ngOnInit() {
    this.prodottiService.listaprodotti().subscribe(response => {this.listaProdotti = response.data});
  }

  deleteProduct() {
    this.prodottiService.deleteProduct(this.idProdotto).subscribe(response => {this.listaProdotti = response.data});
  }


}




