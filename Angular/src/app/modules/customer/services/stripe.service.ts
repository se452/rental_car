// services/stripe.service.ts
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

declare var Stripe: any;

@Injectable({
  providedIn: 'root'
})
export class StripeService {
  private stripe: any;

  constructor() {
    this.stripe = Stripe(environment.stripePublicKey);
  }

  createCardElement() {
    const elements = this.stripe.elements();
    return elements.create('card', {
      style: {
        base: {
          color: '#32325d',
          fontFamily: '"Helvetica Neue", Helvetica, sans-serif',
          fontSmoothing: 'antialiased',
          fontSize: '16px',
          '::placeholder': {
            color: '#aab7c4'
          }
        },
        invalid: {
          color: '#fa755a',
          iconColor: '#fa755a'
        }
      }
    });
  }

  async createPaymentMethod(cardElement: any): Promise<any> {
    try {
      const { paymentMethod, error } = await this.stripe.createPaymentMethod({
        type: 'card',
        card: cardElement,
      });

      if (error) {
        throw error;
      }
      return paymentMethod;
    } catch (error) {
      throw error;
    }
  }
}