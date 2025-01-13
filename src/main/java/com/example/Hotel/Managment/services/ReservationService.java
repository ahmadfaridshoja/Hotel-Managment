package com.example.Hotel.Managment.services;

import com.example.Hotel.Managment.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    ReservationDto createReservation(ReservationDto reservationDto);

    ReservationDto getReservationById(Long id);

    List<ReservationDto> getAllReservations();

    ReservationDto updateReservation(Long id, ReservationDto reservationDto);

    void deleteReservation(Long id);
}