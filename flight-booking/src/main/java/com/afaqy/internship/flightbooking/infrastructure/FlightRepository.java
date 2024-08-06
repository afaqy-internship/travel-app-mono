package com.afaqy.internship.flightbooking.infrastructure;

import com.afaqy.internship.flightbooking.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
