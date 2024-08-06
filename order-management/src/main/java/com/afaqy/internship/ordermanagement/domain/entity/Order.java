package com.afaqy.internship.ordermanagement.domain.entity;

import com.afaqy.internship.flightbooking.domain.entity.Flight;
import com.afaqy.internship.hotelbooking.domain.entity.Hotel;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tb_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
