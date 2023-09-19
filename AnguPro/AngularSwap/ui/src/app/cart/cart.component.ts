import { Component, OnInit } from '@angular/core';
import { CycleService } from '../Service';
import { Cycle } from '../cycle';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  cartCycles:any; 
  

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getAllCartCycles();
  }

  getAllCartCycles() {
    this.cycleService.getAllCartCycles().subscribe(data => {
      this.cartCycles = data;
    });
  }

}
