import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CycleService {

  constructor(private httpClient: HttpClient) { }

  getAllCycles(): Observable<any> {
    return this.httpClient.get('http://localhost:8080/api/cycles/list');
  }

  borrowCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post('http://localhost:8080/api/cycles/borrow', requestData);
  }

  returnCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post('http://localhost:8080/api/cycles/return', requestData);
  }

  reStockCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post('http://localhost:8080/api/cycles/cycleList', requestData);
  }
}


