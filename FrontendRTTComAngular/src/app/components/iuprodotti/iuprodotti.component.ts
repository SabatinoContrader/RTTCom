import {Prodotto} from '../../models/prodotto.model';
import {ProdottiService} from '../../services/prodotti.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-iuprodotti',
  templateUrl: './iuprodotti.component.html',
  styleUrls: ['./iuprodotti.component.css']
})
export class IuprodottiComponent implements OnInit {
  id: number;
  ean: string;
  category: string;
  model: string;
  manufacturer: string;
  description: string;
  longDescription: string;
  sellPrice: number;
  prodotto: Prodotto;

  constructor(private prodottiService: ProdottiService, private router: Router) {}

  ngOnInit() {
  }

  insertProdotto() {
    this.prodottiService.insertprodotti(this.id, this.ean, this.category, this.model, this.manufacturer,
      this.description, this.longDescription, this.sellPrice).subscribe((response) => {
        this.prodotto = response;
        this.router.navigateByUrl("prodotti");
      });
  }

}
