import { Component, OnInit } from '@angular/core';
import { CycleService } from './Service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  cycles: any;

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getCycles();
  }

  getCycles() {
    this.cycleService.getAllCycles().subscribe(data => {
      this.cycles = data;
    });
  }

  borrowCycle(cycleId: number, quantity: number) {
    this.cycleService.borrowCycle(cycleId, quantity).subscribe(response => {
      const cycleIndex = this.cycles.findIndex(cycleId);
      if (cycleIndex !== -1) {
        this.cycles[cycleIndex].stockCount -= quantity;
      }

      console.log(response); 
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

  returnCycle(cycleId: number, quantity: number) {
    this.cycleService.returnCycle(cycleId, quantity).subscribe(response => {
      const cycleIndex = this.cycles.findIndex(cycleId);
      if (cycleIndex !== -1 && this.cycles[cycleIndex].numBorrowed >= quantity) {
        this.cycles[cycleIndex].stockCount += quantity;
      }else{
        console.log("All borrowed returned!")
      }

      console.log(response); 
    });
  }

}

