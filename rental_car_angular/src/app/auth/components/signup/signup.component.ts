import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})

export class SignupComponent { 
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  onRegister() {
    // Implement register logic here
    if (this.password === this.confirmPassword) {
      console.log('Email:', this.email, 'Password:', this.password);
    } else {
      console.error("Passwords don't match!");
    }
  }
}
