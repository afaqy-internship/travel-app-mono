package com.afaqy.internship.mshotelbooking.adapters.rest;

import com.afaqy.internship.mshotelbooking.domain.entity.Hotel;
import com.afaqy.internship.mshotelbooking.domain.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hotels")
@Slf4j
public class HotelApiDelegate {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotels() {
        return ResponseEntity.ok().body(this.hotelService.getHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findHotel(@PathVariable("id") Long id) {
        var order = this.hotelService.getHotel(id);
        return order.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = this.hotelService.createNewHotel(hotel);
        log.info("Saved Hotel {}", savedHotel);
        return ResponseEntity.status(201).body(savedHotel);
    }
}
