// components/payment-form/payment-form.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PaymentService } from '../../services/payment.service';
import { StripeService } from '../../services/stripe.service';
import { PaymentResponse } from '../../models/payment.model';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent implements OnInit {
  paymentForm: FormGroup;
  loading = false;
  error = '';
  cardElement: any;
  showAlert = false;
  alertType: 'success' | 'error' = 'success';
  alertTitle = '';
  alertMessage = '';
  
  constructor(
    private fb: FormBuilder,
    private paymentService: PaymentService,
    private stripeService: StripeService,
    private router: Router
  ) {
    this.paymentForm = this.fb.group({
      amount: ['', [Validators.required, Validators.min(0)]],
      booking_id: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.setupStripeElement();
  }

  private setupStripeElement() {
    this.cardElement = this.stripeService.createCardElement();
    this.cardElement.mount('#card-element');

    // Add event listener for errors
    this.cardElement.on('change', (event: any) => {
      const displayError = document.getElementById('card-errors');
      if (displayError) {
        displayError.textContent = event.error ? event.error.message : '';
      }
    });
  }

  async onSubmit() {
    if (this.paymentForm.invalid) return;

    this.loading = true;
    this.error = '';

    try {
      console.log('Creating payment method...');
      const paymentMethod = await this.stripeService.createPaymentMethod(this.cardElement);
      console.log('Payment method created:', paymentMethod);

      const paymentRequest = {
        ...this.paymentForm.value,
        payment_method_id: paymentMethod.id,
        currency: 'USD'
      };

      console.log('Initiating payment...', paymentRequest);
      const paymentResponse = await firstValueFrom(
        this.paymentService.initiatePayment(paymentRequest)
      );
      console.log('Payment initiated:', paymentResponse);

      if (!paymentResponse) {
        throw new Error('Failed to initiate payment');
      }

      console.log('Confirming payment...');
      const confirmResponse = await firstValueFrom(
        this.paymentService.confirmPayment(
          paymentResponse.paymentId,
          paymentMethod.id,
          paymentRequest.booking_id
        )
      );
      console.log('Payment confirmed:', confirmResponse);

      if (confirmResponse) {
        // Show success alert
        this.showSuccessAlert();
        
        // Wait for 1.5 seconds before redirecting to success page
        setTimeout(() => {
          this.router.navigate(['/success'], {
            state: {
              transactionId: paymentResponse.paymentId,
              amount: this.paymentForm.get('amount')?.value,
              date: new Date(),
              bookingId: this.paymentForm.get('booking_id')?.value
            }
          });
        }, 1500);
      } else {
        throw new Error('Payment confirmation failed');
      }
      
    } catch (err: any) {
      console.error('Payment error:', err);
      this.showErrorAlert(err);
      
      // Navigate to failure page
      setTimeout(() => {
        this.router.navigate(['/failed'], {
          state: {
            errorCode: err.code || 'UNKNOWN',
            errorMessage: err.message || 'An unexpected error occurred',
            transactionId: err.transactionId,
            bookingId: this.paymentForm.get('booking_id')?.value,
            timestamp: new Date()
          }
        });
      }, 1500);
    } finally {
      this.loading = false;
    }
  }

  private showSuccessAlert() {
    this.alertType = 'success';
    this.alertTitle = 'Payment Successful!';
    this.alertMessage = 'Your payment has been processed successfully.';
    this.showAlert = true;
  }

  private showErrorAlert(error: any) {
    this.alertType = 'error';
    this.alertTitle = 'Payment Failed';
    this.alertMessage = error.message || 'An error occurred while processing your payment.';
    this.showAlert = true;
  }

  private resetForm() {
    this.paymentForm.reset();
    this.cardElement.clear();
    this.error = '';
  }
}