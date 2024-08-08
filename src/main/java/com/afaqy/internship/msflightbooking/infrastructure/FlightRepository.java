package com.afaqy.internship.msflightbooking.infrastructure;

import com.afaqy.internship.msflightbooking.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
