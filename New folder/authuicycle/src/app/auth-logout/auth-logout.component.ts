import { Component, Inject } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-auth-logout',
  template: `
    <ng-container *ngIf="auth.isAuthenticated$ | async; else loggedOut">
      <a (click)="auth.logout({ logoutParams: { returnTo: document.location.origin } })">
        AuthLogout
    </a>
    </ng-container>

    <ng-template #loggedOut>
      <a (click)="auth.loginWithRedirect()">AuthLogin</a>
    </ng-template>
  `,
  styles: [],
})
export class AuthLogoutComponent {
  constructor(@Inject(DOCUMENT) public document: Document, public auth: AuthService) {}
}