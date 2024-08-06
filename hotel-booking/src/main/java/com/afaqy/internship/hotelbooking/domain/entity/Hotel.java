package com.afaqy.internship.hotelbooking.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "tb_hotel")
@RequiredArgsConstructor
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nights")
    private Integer nights;

}
