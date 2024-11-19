// components/payment-history/payment-history.component.ts
import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../../services/payment.service';
import { PaymentHistory } from '../../models/payment.model';

@Component({
  selector: 'app-payment-history',
  templateUrl: './payment-history.component.html',
  styleUrls: ['./payment-history.component.css']
})
export class PaymentHistoryComponent implements OnInit {
  paymentHistory: PaymentHistory[] = [];
  loading = false;
  error = '';
  bookingIds: number[] = [1234, 5678]; // Example booking IDs - replace with your actual data

  constructor(private paymentService: PaymentService) {}

  ngOnInit() {
    this.loadAllPaymentHistory();
  }

  loadAllPaymentHistory() {
    this.loading = true;
    this.error = '';
    const allPaymentHistory: PaymentHistory[] = [];

    // Create an array of promises for all booking IDs
    const promises = this.bookingIds.map(bookingId =>
      this.paymentService.getPaymentHistory(bookingId).toPromise()
    );

    // Wait for all promises to resolve
    Promise.all(promises)
      .then(results => {
        results.forEach(history => {
          if (history) {
            allPaymentHistory.push(...history);
          }
        });
        
        // Sort by timestamp descending (most recent first)
        this.paymentHistory = allPaymentHistory.sort((a, b) => 
          new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime()
        );

        if (this.paymentHistory.length === 0) {
          this.error = 'No payment history found';
        }
      })
      .catch(err => {
        this.error = 'Failed to load payment history: ' + (err.message || 'Unknown error');
      })
      .finally(() => {
        this.loading = false;
      });
  }

  // Helper method to format date
  formatDate(date: Date): string {
    return new Date(date).toLocaleString();
  }

  // Helper method to format amount
  formatAmount(amount: number): string {
    return new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD'
    }).format(amount);
  }

  // Helper method for status badge class
  getStatusClass(status: string): string {
    switch (status.toLowerCase()) {
      case 'completed':
        return 'status-success';
      case 'pending':
        return 'status-pending';
      case 'failed':
        return 'status-failed';
      default:
        return 'status-default';
    }
  }
}