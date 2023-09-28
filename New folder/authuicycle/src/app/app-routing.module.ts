import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestockComponent } from './restock/restock.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { OrdercomComponent } from './ordercom/ordercom.component';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { AuthLogoutComponent } from './auth-logout/auth-logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [{ path: 'restock', component: RestockComponent }, { path: 'exchange', component: ExchangeComponent }, { path: 'cart', component: CartComponent }, { path: 'payment', component: PaymentComponent },
{ path: 'login-form', component: LoginFormComponent }, { path: 'ordercom', component: OrdercomComponent }, { path: 'auth-login', component: AuthLoginComponent }, { path: 'auth-logout', component: AuthLogoutComponent }, { path: 'user-profile', component: UserProfileComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
