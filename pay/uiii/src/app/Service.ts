import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CycleService {

  constructor(private httpClient: HttpClient) { }

  getAllCartCycles(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.get('http://localhost:8080/api/cycles/cartList' , {headers: headers});
  }

  addCycleCart(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.post('http://localhost:8080/api/cycles/cartAdd', requestData , {headers: headers});
  }

  getAllCycles(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.get('http://localhost:8080/api/cycles/list' , {headers: headers});
  }

  borrowCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.post('http://localhost:8080/api/cycles/borrow', requestData , {headers: headers});
  }

  returnCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.post('http://localhost:8080/api/cycles/return', requestData , {headers: headers});
  }

  reStockCycle(cycleId: number, quantity: number): Observable<any> {
    const requestData = {
      cycleId: cycleId,
      quantity: quantity
    };
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.post('http://localhost:8080/api/cycles/restock', requestData , {headers: headers});
  }

  payment(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token') 
    });
    return this.httpClient.get('http://localhost:8080/api/cycles/payment' , {headers: headers});
  }
}


