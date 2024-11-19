// components/payment-fail/payment-fail.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-fail',
  templateUrl: './payment-fail.component.html',
  styleUrls: ['./payment-fail.component.css']
})
export class PaymentFailComponent implements OnInit {
  errorDetails = {
    errorCode: '',
    errorMessage: '',
    transactionId: '',
    bookingId: '',
    timestamp: new Date()
  };

  constructor(private router: Router) {
    // Get error details from navigation state
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state) {
      this.errorDetails = { ...this.errorDetails, ...navigation.extras.state };
    }
  }

  ngOnInit(): void {}

  retryPayment() {
    this.router.navigate(['/payment']);
  }

  contactSupport() {
    // Implement your support logic here
    window.location.href = 'mailto:support@example.com';
  }

  goToHome() {
    this.router.navigate(['/']);
  }
}