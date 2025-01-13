package com.example.Hotel.Managment.repositories;


import com.example.Hotel.Managment.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}