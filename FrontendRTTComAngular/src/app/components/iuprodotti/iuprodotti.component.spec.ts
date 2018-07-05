import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {IuprodottiComponent} from './iuprodotti.component';

describe('IuprodottiComponent', () => {
  let component: IuprodottiComponent;
  let fixture: ComponentFixture<IuprodottiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [IuprodottiComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IuprodottiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
