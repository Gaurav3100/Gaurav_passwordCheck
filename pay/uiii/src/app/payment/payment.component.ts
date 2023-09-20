import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  cartCycles: any[] = [];
  totalPayment: number = 0;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.fetchPaymentData();
  }

  fetchPaymentData() {
    this.http.get('http://localhost:8080/api/cycles/payment').subscribe((data: any) => {
      this.cartCycles = data.cartCycles;
      this.totalPayment = data.totalPayment;
    });
  }
}
