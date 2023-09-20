import { Component } from '@angular/core';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
username : string = "";
password : string = "";


constructor( private authService :AuthService){}

login() : void
{
  this.authService.login(this.username, this.password).subscribe();
}
}