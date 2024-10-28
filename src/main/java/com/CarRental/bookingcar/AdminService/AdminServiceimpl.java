package com.CarRental.bookingcar.AdminService;

import java.util.Objects;
import java.util.Optional;

import com.CarRental.bookingcar.BookACarRepository;
import com.CarRental.bookingcar.BookCarDto;
import com.CarRental.bookingcar.BookCarStatus;
import com.CarRental.bookingcar.BookACar;
import com.CarRental.bookingcar.AdminService.AdminService;

public class AdminServiceimpl implements AdminService {

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
    }

}
