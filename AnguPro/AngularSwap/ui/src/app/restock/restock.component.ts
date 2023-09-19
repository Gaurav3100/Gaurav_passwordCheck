import { Component, OnInit} from '@angular/core';
import { CycleService } from '../Service';

@Component({
  selector: 'app-restock',
  templateUrl: './restock.component.html',
  styleUrls: ['./restock.component.css']
})
export class RestockComponent implements OnInit{
  cycles:any;
  cycleId:number=0;
  quantity:number=0;
  message: any;

  constructor(private cycleService: CycleService) { }

  ngOnInit() {
    this.getCycles();
  }

  getCycles() {
    this.cycleService.getAllCycles().subscribe(data => {
      this.cycles = data;
    });
  }

  reStockCycle() {
    if(this.cycleId && this.quantity){
      this.cycleService.reStockCycle(this.cycleId, this.quantity).subscribe(
        (response) => {
          console.log('API Response:', response); 
          if (response && response.message) {
            this.message = response.message;
            this.cycleId = 0;
            this.quantity = 0;
            this.ngOnInit();
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
