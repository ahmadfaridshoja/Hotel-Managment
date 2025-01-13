package com.example.Hotel.Managment.mapper;

import com.example.Hotel.Managment.dto.ReservationDto;
import com.example.Hotel.Managment.models.Reservation;

    public class ReservationMapper {

        public static ReservationDto toDto(Reservation reservation) {
            ReservationDto dto = new ReservationDto();
            dto.setId(reservation.getId());
            dto.setGuestId(reservation.getGuest().getId());
            dto.setRoomId(reservation.getRoom().getId());
            dto.setCheckInDate(reservation.getCheckInDate());
            dto.setCheckOutDate(reservation.getCheckOutDate());
            return dto;
        }

        public static Reservation toEntity(ReservationDto dto) {
            Reservation reservation = new Reservation();
            reservation.setCheckInDate(dto.getCheckInDate());
            reservation.setCheckOutDate(dto.getCheckOutDate());
            return reservation;
        }
    }

