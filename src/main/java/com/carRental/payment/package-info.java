/**
 * This package contains classes and components related to the payment functionality 
 * of the Car Rental Application.
 * 
 * <p>The payment functionality is responsible for processing payments for car rentals
 * using the Stripe payment gateway. It includes:
 * </p>
 * 
 * <ul>
 *   <li>API endpoints to initiate and manage payment transactions.</li>
 *   <li>Integration with the Stripe SDK for secure and seamless payment processing.</li>
 *   <li>Handling of customer payment information, including tokenized card details.</li>
 *   <li>Error handling and responses for failed payment transactions.</li>
 * </ul>
 * 
 * <p>Key Components:
 * </p>
 * <ul>
 *   <li><b>PaymentController</b>: A REST controller that exposes APIs for frontend interaction,
 *       including initiating payment charges.</li>
 *   <li><b>PaymentRequest</b>: A data transfer object (DTO) that encapsulates the details of
 *       a payment request, such as amount and tokenized card information.</li>
 *   <li><b>Stripe Integration</b>: Utilizes the Stripe Java SDK for securely processing
 *       payment requests and handling transaction responses.</li>
 * </ul>
 * 
 * <p>Usage:
 * </p>
 * <ol>
 *   <li>The frontend sends a payment request containing the tokenized card information
 *       and the payment amount to the backend via the <code>/api/payments/charge</code> endpoint.</li>
 *   <li>The backend processes the request using the Stripe SDK, creating a charge and
 *       returning the result to the frontend.</li>
 *   <li>The frontend displays the success or failure of the payment to the user.</li>
 * </ol>
 * 
 * <p>This package ensures secure and reliable payment processing, adhering to best practices 
 * in payment handling and security.
 * </p>
 * 
 * <p>Note: Replace the placeholder `your-stripe-secret-key` with the actual Stripe API key 
 * for production deployment.
 * </p>
 * 
 * @author : harish kumar kovuru
 */
package com.carRental.payment;
