import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntestazioneComponent } from './intestazione.component';

describe('IntestazioneComponent', () => {
  let component: IntestazioneComponent;
  let fixture: ComponentFixture<IntestazioneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntestazioneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntestazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
