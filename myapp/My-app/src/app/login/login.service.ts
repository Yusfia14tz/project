import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private isLoggedIn: boolean = false;

  login(username: string, password: string): boolean {
    // Check if both username and password are not empty
    if (username.trim() !== '' && password.trim() !== '') {
      // Perform login validation
      if (username === 'admin' && password === 'password') {
        this.isLoggedIn = true;
        return true;
      } else {
        this.isLoggedIn = false;
        return false;
      }
    } else {
      // If either username or password is empty, return false
      this.isLoggedIn = false;
      return false;
    }
  }

  isUserLoggedIn(): boolean {
    return this.isLoggedIn;
  }

  logout(): void {
    this.isLoggedIn = false;
  }
}