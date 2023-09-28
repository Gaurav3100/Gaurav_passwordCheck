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

  borrowCycle() {
    if (this.quantity > 0) {
      this.cycleService.borrowCycle(this.cycleId, this.quantity).subscribe(
        (response) => {
          console.log('API Response:', response);
          if (response && response.message) {
            this.message = response.message;
            const cycleIndex = this.findCycleIndex(this.cycleId);
            if (cycleIndex !== -1) {
              this.cycles[cycleIndex].stockCount -= this.quantity;
              this.cycleId = null;
              this.quantity = null;
              this.ngOnInit();
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

  returnCycle() {
    if (this.quantity > 0) {
      const cycleIndex = this.findCycleIndex(this.cycleId);
      
      if (cycleIndex !== -1) {
        const borrowedQuantity = this.cycles[cycleIndex].numBorrowed;
  
        if (this.quantity <= borrowedQuantity) {
          this.cycleService.returnCycle(this.cycleId, this.quantity).subscribe(
            (response) => {
              console.log('API Response:', response);
              if (response && response.message) {
                this.message = response.message;
                this.cycles[cycleIndex].stockCount += this.quantity;
                this.cycles[cycleIndex].numBorrowed -= this.quantity;
                this.cycleId = null;
                this.quantity = null;
                this.ngOnInit();
              } else {
                this.message = 'Unexpected response from the server';
              }
            },
            (error) => {
              console.error('API Error:', error);
            }
          );
        } else {
          this.message = 'Cannot return more cycles than borrowed';
        }
      } else {
        this.message = 'Cycle not found';
      }
    }
  }
  

  addCycleCart() {
    if (this.quantity > 0) {
      this.cycleService.addCycleCart(this.cycleId, this.quantity).subscribe(
        (response) => {
          console.log('API Response:', response);
          if (response && response.message) {
            this.message = response.message;
            const cycleIndex = this.findCycleIndex(this.cycleId);
            if (cycleIndex !== -1) {
              this.cartCycles[cycleIndex].quantity += this.quantity;
              this.cycleId = null;
              this.quantity = null;
              this.ngOnInit();
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
      this.ngOnInit();
    }
  }

}
