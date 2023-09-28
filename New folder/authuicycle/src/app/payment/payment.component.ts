import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CycleService } from '../Service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  cartCycles: any[] = [];
  totalPayment: number = 0;

  constructor(private http: HttpClient, private cycleService: CycleService) { } 

  ngOnInit() {
    this.fetchPaymentData();
  }

  fetchPaymentData() {
    this.http.get('http://localhost:8080/api/cycles/payment').subscribe((data: any) => {
      this.cartCycles = data.cartCycles;
      this.totalPayment = data.totalPayment;
    });
  }

  onProceedToCheckoutClick() {
    this.cycleService.emptyCart().subscribe(() => {

      for (const cartItem of this.cartCycles) {
        this.cycleService.decreaseStockCount(cartItem.cycleId, cartItem.quantity).subscribe(
          () => {
            console.log(`Stock count decreased for item with ID ${cartItem.cycleId}`);
          },
          (error) => {
            console.error(`Error decreasing stock count for item with ID ${cartItem.cycleId}:`, error);
          }
        );
      }
      this.cartCycles = [];
    });
  }
}
