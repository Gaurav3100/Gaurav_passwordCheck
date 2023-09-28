import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdercomComponent } from './ordercom.component';

describe('OrdercomComponent', () => {
  let component: OrdercomComponent;
  let fixture: ComponentFixture<OrdercomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrdercomComponent]
    });
    fixture = TestBed.createComponent(OrdercomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
