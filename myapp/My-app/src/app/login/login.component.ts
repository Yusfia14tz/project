import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login = {
    username: '',
    password: ''
  };

  onSubmit(loginForm: NgForm) {
    if (loginForm.valid) {
      // Proceed with login logic, e.g., calling a login service
      console.log('Form Submitted!', this.login);
      // Redirect to attendance tracker
      window.location.href = 'attendance1';
    }
  }
}
