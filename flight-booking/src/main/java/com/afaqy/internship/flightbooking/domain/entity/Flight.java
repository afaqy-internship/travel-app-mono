package com.afaqy.internship.flightbooking.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "tb_flight")
@RequiredArgsConstructor
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_airport")
    private String fromAirport;

    @Column(name = "to_airport")
    private String toAirport;
}
