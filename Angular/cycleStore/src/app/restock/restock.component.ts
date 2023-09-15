import { Component, OnInit } from '@angular/core';
import { CycleService } from '../Service';

@Component({
  selector: 'app-restock',
  templateUrl: './restock.component.html',
  styleUrls: ['./restock.component.css']
})
export class RestockComponent implements OnInit{
  cycles:any;

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getCycles();
  }

  getCycles() {
    this.cycleService.getAllCycles().subscribe(data => {
      this.cycles = data;
    });
  }

  reStockCycle(cycleId: number, quantity: number) {
    this.cycleService.returnCycle(cycleId, quantity).subscribe(response => {
      const cycleIndex = this.cycles.findIndex(cycleId);
      if (cycleIndex !== -1) {
        this.cycles[cycleIndex].stockCount += quantity;
      }

      console.log(response); 
    });
  }

}
