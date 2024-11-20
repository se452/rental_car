package com.carRental.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        String transactionId = "txn_" + System.currentTimeMillis();

        Transaction transaction = new Transaction(transactionId, paymentRequest.getAmount(), "success");
        transactionRepository.save(transaction);

        return new PaymentResponse("success", transactionId);
    }

    @Override
    public boolean refundPayment(String transactionId) {

        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
        if (transaction != null) {
            transaction.setStatus("refunded");
            transactionRepository.save(transaction);
            return true;
        }
        return false;
    }
}
