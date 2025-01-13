package com.example.Hotel.Managment.dto;

import java.time.LocalDate;
public class ReservationDto {
        private Long id;
        private Long guestId;
        private Long roomId;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getGuestId() {
                return guestId;
        }

        public void setGuestId(Long guestId) {
                this.guestId = guestId;
        }

        public Long getRoomId() {
                return roomId;
        }

        public void setRoomId(Long roomId) {
                this.roomId = roomId;
        }

        public LocalDate getCheckOutDate() {
                return checkOutDate;
        }

        public void setCheckOutDate(LocalDate checkOutDate) {
                this.checkOutDate = checkOutDate;
        }

        public LocalDate getCheckInDate() {
                return checkInDate;
        }

        public void setCheckInDate(LocalDate checkInDate) {
                this.checkInDate = checkInDate;
        }
}

