package com.carRental.payment.repository;

import com.carRental.payment.entity.Payment;
import com.carRental.bookingcar.BookACar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByBookACar(BookACar bookACar);
    List<Payment> findByStatus(String status);
}