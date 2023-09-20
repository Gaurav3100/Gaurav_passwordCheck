import { Component, OnInit } from '@angular/core';
import { CycleService } from '../Service';
import { Cycle } from '../cycle';
import { FormBuilder } from '@angular/forms';
import { CartService } from '../cart.service';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartCycles: any;
  username: any;
  totalPrice: number = 0;
  items: Cycle[] = [];
  total: number = 0;
  quantity: number = 1;

  // checkoutForm = this.formBuilder.group({
  //   name: ''
  // });

  constructor(
    private cycleService: CycleService,
    private cartService: CartService,
    private formBuilder: FormBuilder,
    private transactionService: TransactionService
  ) { }

  ngOnInit() {
    this.getAllCartCycles();
  }

  getAllCartCycles() {
    this.cycleService.getAllCartCycles().subscribe(data => {
      this.cartCycles = data;
      for(let c of this.cartCycles){
        this.total += c.subTotal();
      }
      // // Calculate the total price based on cart items
      // this.totalPrice = this.cartCycles.reduce((totalPrice: any, cycle: { price: any; }) => totalPrice + cycle.price, 0);
    });
  }

  onSubmit(): void {
    console.log('Before clearing cart:', this.getAllCartCycles()); // Check cart content before clearing
  console.log('Before resetting form:', this.username);
    const purchasedTime = new Date(); // Current date and time
    const items = this.cartCycles;

    // Call your transaction service to add a new transaction
    this.transactionService.addTransaction(this.username, this.items, this.totalPrice, purchasedTime).subscribe(
      () => {       
         console.log('Transaction added successfully.');
        // Optionally, redirect to a different route or perform other actions upon success.
      },
      (error) => {
        console.error('Error adding transaction:', error);
      }
    );

    // Clear the cart and reset the form
    this.cartService.clearCart();
    // this.checkoutForm.reset();
    console.log('After clearing cart:', this.cartService.getItems()); // Check cart content after clearing
  console.log('After resetting form:', this.username);
  }

  removeItemFromCart(cycleId: number,quantity: number) {
    // Call the cart service to remove the item by its cycleId
    this.cycleService.deleteItem(cycleId,quantity).subscribe(
      (): void => {
        // Item removed successfully, refresh the cart
        this.getAllCartCycles();
      },
      (error) => {
        console.error('Error removing item from cart:', error);
      }
    );
  }

  
  
}
