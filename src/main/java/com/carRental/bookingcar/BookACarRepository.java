package com.carRental.bookingcar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookACarRepository extends JpaRepository<BookACar, Long> {



    List<BookACar> findByUser_id(Long user_id);

}
