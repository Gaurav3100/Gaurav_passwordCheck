import { Component } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-auth-login',
  template: '<button (click)="auth.loginWithRedirect()">Log in</button>',
  styleUrls: ['./auth-login.component.css']
})
export class AuthLoginComponent {

  constructor(public auth: AuthService) {}

}
