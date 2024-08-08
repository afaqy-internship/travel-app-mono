package com.afaqy.internship.mshotelbooking.domain.service;

import com.afaqy.internship.mshotelbooking.domain.entity.Hotel;
import com.afaqy.internship.mshotelbooking.infrastructure.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getHotels() {
        return this.hotelRepository.findAll();
    }

    public Optional<Hotel> getHotel(Long id) {
        return this.hotelRepository.findById(id);
    }

    @Transactional
    public Hotel createNewHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }
}
