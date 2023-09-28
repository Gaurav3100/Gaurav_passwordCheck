import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CycleService {

  private apiUrl = 'http://localhost:8080/api/cycles';
  constructor(private httpClient: HttpClient) { }


  getAllCartCycles(): Observable<any> {  //observable stream to return value of any type
    return this.httpClient.get(`${this.apiUrl}/cartList`);
  }

  addCycleCart(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post(`${this.apiUrl}/cartAdd`, requestData);
  }

  removeCycleCart(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post(`${this.apiUrl}/cartRemove`, requestData);
  }

  getAllCycles(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/list`);
  }

  borrowCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post(`${this.apiUrl}/borrow` , requestData);
  }

  returnCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post(`${this.apiUrl}/return`, requestData);
  }

  reStockCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    return this.httpClient.post(`${this.apiUrl}/restock`, requestData);
  }

  payment(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/payment`);
  }

  emptyCart() {
    return this.httpClient.delete(`${this.apiUrl}/cartList`);
  }

  decreaseStockCount(cycleId: number, quantity: number) {
    const requestData = { cycleId, quantity };
    return this.httpClient.post(`${this.apiUrl}/return` , requestData);
  }

  getTotalUniqueCartItems(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/totalUniqueCartItems`);
  }
  
}


