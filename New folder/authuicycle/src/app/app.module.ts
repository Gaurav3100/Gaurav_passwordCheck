import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestockComponent } from './restock/restock.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { CartComponent } from './cart/cart.component';
import { FormsModule } from '@angular/forms';
import { PaymentComponent } from './payment/payment.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { OrdercomComponent } from './ordercom/ordercom.component';
import { HttpInterceptorService } from './HttpInterceptorService ';
import { AuthModule } from '@auth0/auth0-angular';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { AuthLogoutComponent } from './auth-logout/auth-logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    RestockComponent,
    ExchangeComponent,
    CartComponent,
    LoginFormComponent,
    PaymentComponent,
    OrdercomComponent,
    AuthLoginComponent,
    AuthLogoutComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AuthModule.forRoot({
      domain: 'dev-rtyj1tmziwnt1lqj.us.auth0.com',
      clientId: '9x5WSpamm77OvuLNSMWKWqgRNyDqnDWb',
      authorizationParams: {
        redirect_uri: window.location.origin 
      }
    }),
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
