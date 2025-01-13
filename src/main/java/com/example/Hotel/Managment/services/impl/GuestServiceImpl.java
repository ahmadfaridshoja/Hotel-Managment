package com.example.Hotel.Managment.services.impl;


import com.example.Hotel.Managment.dto.GuestDto;
import com.example.Hotel.Managment.mapper.GuestMapper;
import com.example.Hotel.Managment.repositories.GuestRepository;
import com.example.Hotel.Managment.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public GuestDto createGuest(GuestDto guestDto) {
        return GuestMapper.toDto(guestRepository.save(GuestMapper.toEntity(guestDto)));
    }

    @Override
    public GuestDto getGuestById(Long id) {
        return guestRepository.findById(id)
                .map(GuestMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    @Override
    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(GuestMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}