import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user = {
    name: '',
    username: '',
    email: '',
    address: '',
    password: ''
  };

  onSubmit(registerForm: NgForm) {
    if (registerForm.valid) {
      // Proceed with registration logic, e.g., calling a registration service
      console.log('Form Submitted!', this.user);
      // Redirect to login page or show a success message
      window.location.href = 'login';
    }
  }
}


