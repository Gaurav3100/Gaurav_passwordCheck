import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TotalItemsService {
  private totalItemsSubject = new BehaviorSubject<number>(0);

  totalItems$ = this.totalItemsSubject.asObservable();

  updateTotalItems(totalItems: number) {
    this.totalItemsSubject.next(totalItems);
  }
}
