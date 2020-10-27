import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContinueToCheckoutComponent } from './continue-to-checkout.component';

describe('ContinueToCheckoutComponent', () => {
  let component: ContinueToCheckoutComponent;
  let fixture: ComponentFixture<ContinueToCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContinueToCheckoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContinueToCheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
