import { TestBed, inject } from '@angular/core/testing';

import { ProdottiService } from './prodotti.service';

describe('ProdottiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProdottiService]
    });
  });

  it('should be created', inject([ProdottiService], (service: ProdottiService) => {
    expect(service).toBeTruthy();
  }));
});
