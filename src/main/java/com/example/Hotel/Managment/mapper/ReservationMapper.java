package com.example.Hotel.Managment.mapper;

import com.example.Hotel.Managment.dto.ReservationDto;
import com.example.Hotel.Managment.models.Guest;
import com.example.Hotel.Managment.models.Reservation;
import com.example.Hotel.Managment.models.Room;
import com.example.Hotel.Managment.repositories.GuestRepository;
import com.example.Hotel.Managment.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {


    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

        public  ReservationDto toDto(Reservation reservation) {
            ReservationDto dto = new ReservationDto();
            dto.setId(reservation.getId());
            if (reservation.getGuest() != null) {
                dto.setGuestId(reservation.getGuest().getId());
            }

            if (reservation.getRoom() != null) {
                dto.setRoomId(reservation.getRoom().getId());
            }
            dto.setCheckInDate(reservation.getCheckInDate());
            dto.setCheckOutDate(reservation.getCheckOutDate());
            return dto;
        }

        public  Reservation toEntity(ReservationDto dto) {
            Reservation reservation = new Reservation();
            Guest guest = guestRepository.findById(dto.getGuestId()).orElseThrow(() -> new RuntimeException("Guest not found"));
            Room room = roomRepository.findById(dto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));

            reservation.setGuest(guest);
            reservation.setRoom(room);
            reservation.setCheckInDate(dto.getCheckInDate());
            reservation.setCheckOutDate(dto.getCheckOutDate());
            return reservation;
        }
    }

