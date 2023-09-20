import { Component, OnInit } from '@angular/core';
import { CycleService } from '../Service';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit{

  cycles: any;
  message: any;
  cycleId: any;
  quantity: any;
  price: any;
  cartCycles: any;

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getCycles();
    this.getAllCartCycles();
  }

  getCycles() {
    this.cycleService.getAllCycles().subscribe(data => {
      this.cycles = data;
    });
  }

  getAllCartCycles() {
    this.cycleService.getAllCartCycles().subscribe(data => {
      this.cartCycles = data;
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

  findCycleIndex(cycleId: number): number {
    for (let i = 0; i < this.cycles.length; i++) {
      if (this.cycles[i].id === cycleId) {
        return i; 
      }
    }
    return -1; 
  }

  borrowCycle(cycleId: number, quantity: number) {
    if (quantity > 0) {
      this.cycleService.borrowCycle(cycleId, quantity).subscribe(
        (response) => {
          console.log('API Response:', response);
          if (response && response.message) {
            this.message = response.message;
            const cycleIndex = this.findCycleIndex(cycleId);
            if (cycleIndex !== -1) {
              this.cycles[cycleIndex].stockCount -= quantity;
            } else {
              this.message = 'Cycle not found';
            }
          } else {
            this.message = 'Unexpected response from the server';
          }
        },
        (error) => {
          console.error('API Error:', error);
        }
      );
    }
  }

  returnCycle(cycleId: number, quantity: number) {
    if (quantity > 0) {
      this.cycleService.returnCycle(cycleId, quantity).subscribe(
        (response) => {
          console.log('API Response:', response);
          if (response && response.message) {
            this.message = response.message;
            const cycleIndex = this.findCycleIndex(cycleId);
            if (cycleIndex !== -1) {
              this.cycles[cycleIndex].stockCount += quantity;
            } else {
              this.message = 'Cycle not found';
            }
          } else {
            this.message = 'Unexpected response from the server';
          }
        },
        (error) => {
          console.error('API Error:', error);
        }
      );
    }
  }

  addCycleCart(cycleId: number, quantity: number) {
    if (quantity > 0) {
      this.cycleService.addCycleCart(cycleId, quantity).subscribe(
        (response) => {
          console.log('API Response:', response);
          if (response && response.message) {
            this.message = response.message;
            const cycleIndex = this.findCycleIndex(cycleId);
            if (cycleIndex !== -1) {
              this.cartCycles[cycleIndex].quantity += quantity;
              this.cycles[cycleIndex].quantity -= quantity;
            } else {
              this.message = 'Cycle not found';
            }
          } else {
            this.message = 'Unexpected response from the server';
          }
        },
        (error) => {
          console.error('API Error:', error);
        }
      );
    }
  }

}
