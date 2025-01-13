package com.example.Hotel.Managment.services.impl;

import com.example.Hotel.Managment.dto.RoomDto;
import com.example.Hotel.Managment.mapper.RoomMapper;
import com.example.Hotel.Managment.repositories.RoomRepository;
import com.example.Hotel.Managment.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntity(roomDto)));
    }

    @Override
    public RoomDto getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(RoomMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto roomDto) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found");
        }
        roomDto.setId(id); // Ensure the room DTO contains the correct ID for update
        return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntity(roomDto)));
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}