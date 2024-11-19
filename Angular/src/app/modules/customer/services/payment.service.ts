// services/payment.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PaymentRequest, PaymentResponse, PaymentHistory } from '../models/payment.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = environment.apiUrl + '/api/payments';

  constructor(private http: HttpClient) {}

  initiatePayment(request: PaymentRequest): Observable<PaymentResponse> {
    return this.http.post<PaymentResponse>(`${this.apiUrl}/initiate`, request);
  }

  confirmPayment(paymentIntentId: string, paymentMethodId: string, bookingId: number): Observable<PaymentResponse> {
    return this.http.post<PaymentResponse>(
      `${this.apiUrl}/confirm`,
      {},
      { params: { paymentIntentId, paymentMethodId, bookingId: bookingId.toString() } }
    );
  }

  getPaymentHistory(bookingId: number): Observable<PaymentHistory[]> {
    return this.http.get<PaymentHistory[]>(`${this.apiUrl}/history/${bookingId}`);
  }
}