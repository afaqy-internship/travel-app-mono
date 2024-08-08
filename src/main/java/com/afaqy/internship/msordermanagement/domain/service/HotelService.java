package com.afaqy.internship.msordermanagement.domain.service;

import com.afaqy.internship.msordermanagement.infrastructure.HotelRepository;
import com.afaqy.internship.msordermanagement.representation.HotelRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.HotelResponseRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelResponseRepresentation create(HotelRequestRepresentation hotelRequestRepresentation) {

        log.info("Save Hotel {}", hotelRequestRepresentation);

         var flight = hotelRepository.newHotel(hotelRequestRepresentation);
         if (flight.getStatusCode().is2xxSuccessful()) {
             return flight.getBody();
         } else {
             throw new RuntimeException("Exception while creating hotel");
         }
    }
}
