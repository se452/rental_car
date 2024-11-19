// components/payment-success/payment-success.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-success',
  templateUrl: './payment-success.component.html',
  styleUrls: ['./payment-success.component.css']
})
export class PaymentSuccessComponent implements OnInit {
  paymentDetails = {
    transactionId: '',
    amount: 0,
    date: new Date(),
    bookingId: ''
  };

  constructor(private router: Router) {
    // Get payment details from navigation state
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state) {
      this.paymentDetails = navigation.extras.state as any;
    }
  }

  ngOnInit() {
    // Auto redirect after 5 seconds
    setTimeout(() => {
      this.goToHistory();
    }, 5000);
  }

  goToHistory() {
    this.router.navigate(['/history']);
  }

  goToHome() {
    this.router.navigate(['/payment']);
  }
}