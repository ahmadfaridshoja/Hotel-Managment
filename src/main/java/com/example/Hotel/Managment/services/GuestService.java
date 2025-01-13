package com.example.Hotel.Managment.services;

import com.example.Hotel.Managment.dto.GuestDto;
import java.util.List;

public interface GuestService {
    GuestDto createGuest(GuestDto guestDto);
    GuestDto getGuestById(Long id);
    List<GuestDto> getAllGuests();
    void deleteGuest(Long id);
}