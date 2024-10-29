package com.carRental.bookingcar.AdminService;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.carRental.bookingcar.BookACarRepository;
import com.carRental.bookingcar.BookCarStatus;
import com.carRental.bookingcar.BookACar;

public class AdminServiceimpl implements AdminService {

    @Autowired
    private BookACarRepository BookACarRepository;

    @Override
    public boolean changeBookingStatus(Long bookingid, String status) {
        // TODO Auto-generated method stub
        Optional<BookACar> optionalBookACar = BookACarRepository.findById(bookingid);
        if (optionalBookACar.isPresent()) {
            BookACar exisistingBookACar = optionalBookACar.get();
            if (Objects.equals(status, "APPROVED")) {
                exisistingBookACar.setBookCarStatus(BookCarStatus.APPROVED);
            } else if (Objects.equals(status, "REJECTED")) {
                exisistingBookACar.setBookCarStatus(BookCarStatus.REJECTED);
                BookACarRepository.save(exisistingBookACar);
                return true;
            }

        }
        return false;
    }

}
