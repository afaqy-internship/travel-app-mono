package com.afaqy.internship.msordermanagement.infrastructure;

import com.afaqy.internship.msordermanagement.representation.FlightRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.FlightResponseRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "FlightService", url = "${apis.ms-flight}/flights")
public interface FlightRepository {

    @PostMapping
    ResponseEntity<FlightResponseRepresentation> newFlight(@RequestBody FlightRequestRepresentation flightRepresentation);
}
