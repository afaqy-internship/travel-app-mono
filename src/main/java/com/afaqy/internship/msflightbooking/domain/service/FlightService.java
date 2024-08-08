package com.afaqy.internship.msflightbooking.domain.service;

import com.afaqy.internship.msflightbooking.domain.entity.Flight;
import com.afaqy.internship.msflightbooking.infrastructure.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public List<Flight> getFlights() {
        return this.flightRepository.findAll();
    }

    public Optional<Flight> getFlight(Long id) {
        return this.flightRepository.findById(id);
    }

    @Transactional
    public Flight createNewFlight(Flight flight) {
        return this.flightRepository.save(flight);
    }
}
