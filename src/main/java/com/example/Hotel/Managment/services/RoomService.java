package com.example.Hotel.Managment.services;

import com.example.Hotel.Managment.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);

    RoomDto getRoomById(Long id);

    List<RoomDto> getAllRooms();

    RoomDto updateRoom(Long id, RoomDto roomDto);

    void deleteRoom(Long id);
}