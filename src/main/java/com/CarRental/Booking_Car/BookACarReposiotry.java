package com.CarRental.Booking_Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookACarReposiotry extends JpaRepository<BookACar, Long> {

}
