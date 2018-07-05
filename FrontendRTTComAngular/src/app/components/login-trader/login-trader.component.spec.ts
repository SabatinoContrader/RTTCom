import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginTraderComponent } from './login-trader.component';

describe('LoginTraderComponent', () => {
  let component: LoginTraderComponent;
  let fixture: ComponentFixture<LoginTraderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginTraderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginTraderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
