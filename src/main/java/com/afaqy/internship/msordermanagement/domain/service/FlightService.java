package com.afaqy.internship.msordermanagement.domain.service;

import com.afaqy.internship.msordermanagement.infrastructure.FlightRepository;
import com.afaqy.internship.msordermanagement.representation.FlightRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.FlightResponseRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightResponseRepresentation create(FlightRequestRepresentation flightRequestRepresentation) {

        log.info("Save flight {}", flightRequestRepresentation);

        var flight = flightRepository.newFlight(flightRequestRepresentation);
         if (flight.getStatusCode().is2xxSuccessful()) {
             return flight.getBody();
         } else {
             throw new RuntimeException("Error occur when save flight [{}] " );
         }
    }
}
