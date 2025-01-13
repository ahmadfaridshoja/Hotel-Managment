package com.example.Hotel.Managment.repositories;

import com.example.Hotel.Managment.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
