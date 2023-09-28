import { Component, OnInit } from '@angular/core';
import { CycleService } from '../Service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  cartCycles:any;
  isCartEmpty:any;
  message: any;
  totalItems: any;

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getAllCartCycles();
  }

  getAllCartCycles() {
    this.cycleService.getAllCartCycles().subscribe(data => {
      this.cartCycles = data;
      this.isCartEmpty = this.cartCycles.length === 0;
    });
  }

  findCycleCartIndex(cycleId: number): number {
    for (let i = 0; i < this.cartCycles.length; i++) {
      if (this.cartCycles[i].id === cycleId) {
        return i; 
      }
    }
    return -1; 
  }

  removeItemFromCart(cycleId: number, quantityToRemove: number) {
    this.cycleService.removeCycleCart(cycleId, quantityToRemove).subscribe(
      (response) => {
        console.log('API Response:', response);
        if (response && response.message === 'Cycle removed from cart successfully') {
          const cycleIndex = this.findCycleCartIndex(cycleId);
          if (cycleIndex !== -1) {
            const currentQuantity = this.cartCycles[cycleIndex].quantity;
            if (currentQuantity > quantityToRemove) {
              this.cartCycles[cycleIndex].quantity -= quantityToRemove;
              this.ngOnInit();
            } else {
              this.cartCycles.splice(cycleIndex, 1); 
              this.ngOnInit();
            }
          } else {
            this.message = 'Cycle not found in cart';
          }
        } else {
          this.message = 'Unexpected response from the server';
        }
      },
      (error) => {
        console.error('API Error:', error);
      }
    );
    this.ngOnInit();
  }
  
}
