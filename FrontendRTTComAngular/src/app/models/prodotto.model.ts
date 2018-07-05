export class Prodotto {
  id: number;
  ean: string;
  category: string;
  model: string;
  manufacturer: string;
  description: string;
  longDescription: string;
  sellPrice: number;

  constructor(id: number, ean: string, category: string, model: string, manufacturer: string,
    description: string, longDescription: string, sellPrice: number) {
    this.id = id;
    this.ean = ean;
    this.category = category;
    this.model = model;
    this.manufacturer = manufacturer;
    this.description = description;
    this.longDescription = longDescription;
    this.sellPrice = sellPrice;
  }

}

