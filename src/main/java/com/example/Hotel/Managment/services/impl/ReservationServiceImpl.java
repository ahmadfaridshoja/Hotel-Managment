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

    @Autowired
    private ReservationMapper reservationMapper; // Inject ReservationMapper as an instance

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        // Using instance method of reservationMapper
        return reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationDto)));
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        // Using instance method of reservationMapper
        return reservationRepository.findById(id)
                .map(reservation -> reservationMapper.toDto(reservation)) // Using instance method
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        // Using instance method of reservationMapper
        return reservationRepository.findAll().stream()
                .map(reservation -> reservationMapper.toDto(reservation)) // Using instance method
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDto updateReservation(Long id, ReservationDto reservationDto) {
        // Ensure the reservation exists before updating
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationDto.setId(id); // Ensure the reservation DTO contains the correct ID for update

        // Using instance method of reservationMapper
        return reservationMapper.toDto(reservationRepository.save(reservationMapper.toEntity(reservationDto)));
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
