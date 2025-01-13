package com.example.Hotel.Managment.mapper;

import com.example.Hotel.Managment.dto.GuestDto;
import com.example.Hotel.Managment.models.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    public static GuestDto toDto(Guest guest) {
        GuestDto dto = new GuestDto();
        dto.setId(guest.getId());
        dto.setFirstName(guest.getFirstName());
        dto.setLastName(guest.getLastName());
        dto.setEmail(guest.getEmail());
        dto.setPhone(guest.getPhone());
        return dto;
    }

    public static Guest toEntity(GuestDto dto) {
        Guest guest = new Guest();
        guest.setFirstName(dto.getFirstName());
        guest.setLastName(dto.getLastName());
        guest.setEmail(dto.getEmail());
        guest.setPhone(dto.getPhone());
        return guest;
    }
}
