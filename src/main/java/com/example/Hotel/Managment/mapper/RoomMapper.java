package com.example.Hotel.Managment.mapper;

import com.example.Hotel.Managment.dto.RoomDto;
import com.example.Hotel.Managment.models.Room;

public class RoomMapper {
    public static RoomDto toDto(Room room) {
            RoomDto dto = new RoomDto();
            dto.setId(room.getId());
            dto.setRoomNumber(room.getRoomNumber());
            dto.setType(room.getType());
            dto.setAvailable(room.isAvailable());
            return dto;
        }

        public static Room toEntity(RoomDto dto) {
            Room room = new Room();
            room.setRoomNumber(dto.getRoomNumber());
            room.setType(dto.getType());
            room.setAvailable(dto.isAvailable());
            return room;
        }
    }

