import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestockComponent } from './restock/restock.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import { LoginFormComponent } from './login-form/login-form.component';

const routes: Routes = [{ path: 'restock', component: RestockComponent },{path: 'exchange', component: ExchangeComponent},{ path: 'cart', component: CartComponent },{ path: 'payment', component: PaymentComponent },
{ path: 'login-form', component: LoginFormComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
