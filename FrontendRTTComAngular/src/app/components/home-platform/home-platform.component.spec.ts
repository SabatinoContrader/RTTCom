import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePlatformComponent } from './home-platform.component';

describe('HomePlatformComponent', () => {
  let component: HomePlatformComponent;
  let fixture: ComponentFixture<HomePlatformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomePlatformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomePlatformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
