package com.afaqy.internship.msordermanagement.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tb_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;

    private Long hotelId;
}
