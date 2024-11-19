package com.carRental.payment.repository;

import com.carRental.payment.entity.PaymentHistory;
import com.carRental.bookingcar.BookACar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    List<PaymentHistory> findByBookACar(BookACar bookACar);
    List<PaymentHistory> findByBookACarOrderByTimestampDesc(BookACar bookACar);
}