package com.afaqy.internship.msflightbooking.adapters.rest;

import com.afaqy.internship.msflightbooking.domain.entity.Flight;
import com.afaqy.internship.msflightbooking.domain.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("flights")
@Slf4j
public class FlightApiDelegate {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> findAllFilghts() {
        return ResponseEntity.ok().body(this.flightService.getFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlight(@PathVariable("id") Long id) {
        var order = this.flightService.getFlight(id);
        return order.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight newFlight = this.flightService.createNewFlight(flight);
        log.info("Saved flight {}", newFlight);
        return ResponseEntity.status(201).body(newFlight);
    }
}
