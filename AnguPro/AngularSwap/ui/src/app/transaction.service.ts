import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Cycle } from './cycle';
import { transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient: HttpClient) { }

   addTransaction(username: string,items: Cycle[],totalPrice: number,purchasedTime: Date): Observable<any>{
   return this.httpClient.post(`http://localhost:8080/api/cycles/addTransaction`, 
   {username:username,items:items,totalPrice:totalPrice,purchasedTime:purchasedTime},{responseType:'json'});
   
   }
}
