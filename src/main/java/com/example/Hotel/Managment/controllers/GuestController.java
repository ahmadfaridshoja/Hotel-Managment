package com.example.Hotel.Managment.controllers;

import com.example.Hotel.Managment.dto.GuestDto;
import com.example.Hotel.Managment.services.GuestService;  // Corrected import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")  // Ensure correct base path
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity<GuestDto> createGuest(@RequestBody GuestDto guestDto) {
        GuestDto createdGuest = guestService.createGuest(guestDto);
        return ResponseEntity.status(201).body(createdGuest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDto> getGuestById(@PathVariable Long id) {
        GuestDto guestDto = guestService.getGuestById(id);
        return ResponseEntity.ok(guestDto);
    }

    @GetMapping
    public ResponseEntity<List<GuestDto>> getAllGuests() {
        List<GuestDto> guestDtos = guestService.getAllGuests();
        return ResponseEntity.ok(guestDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}