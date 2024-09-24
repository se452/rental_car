package com.CarRental.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarRental.user.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
