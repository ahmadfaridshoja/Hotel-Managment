package com.example.Hotel.Managment.repositories;

import com.example.Hotel.Managment.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}