import { Component, OnInit } from '@angular/core';
import { CycleService } from './Service';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  cycles: any;
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  totalUniqueCartItems: number = 0; 

  constructor(private cycleService: CycleService , private authService: AuthService , private router: Router) {}

  ngOnInit() {
    this.getTotalUniqueCartItems();
    this.getCycles();
  }

  getCycles() {
    this.cycleService.getAllCycles().subscribe(data => {
      this.cycles = data;
    });
  }

  getTotalUniqueCartItems() {
    this.cycleService.getTotalUniqueCartItems().subscribe(
      (response) => {
        this.totalUniqueCartItems = response.totalUniqueItems;
        this.ngOnInit();
      },
      (error) => {
        console.error('API Error:', error);
      }
    );
  }


  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/'])
  }
}
