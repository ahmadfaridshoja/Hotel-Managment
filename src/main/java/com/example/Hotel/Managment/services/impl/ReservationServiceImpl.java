package com.example.Hotel.Managment.services.impl;

import com.example.Hotel.Managment.dto.ReservationDto;
import com.example.Hotel.Managment.mapper.ReservationMapper;
import com.example.Hotel.Managment.repositories.ReservationRepository;
import com.example.Hotel.Managment.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        return ReservationMapper.toDto(reservationRepository.save(ReservationMapper.toEntity(reservationDto)));
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(ReservationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDto updateReservation(Long id, ReservationDto reservationDto) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationDto.setId(id); // Ensure the reservation DTO contains the correct ID for update
        return ReservationMapper.toDto(reservationRepository.save(ReservationMapper.toEntity(reservationDto)));
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}