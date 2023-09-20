import { Injectable } from '@angular/core';
import { Cycle } from './cycle';
import { Cart } from './cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  
  items: Cycle[] = [];
/* . . . */

  addToCart(product: Cycle) {
    this.items.push(product);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

  
/* . . . */
}