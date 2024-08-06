package com.afaqy.internship.travelapp.adapters.rest;

import com.afaqy.internship.hotelbooking.domain.entity.Hotel;
import com.afaqy.internship.hotelbooking.domain.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hotels")
public class HotelApiDelegate {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAllOrders() {
        return ResponseEntity.ok().body(this.hotelService.getHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findOrder(@PathVariable("id") Long id) {
        var order = this.hotelService.getHotel(id);
        return order.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hotel> newOrder(@RequestBody Hotel order) {
        return ResponseEntity.status(201).body(this.hotelService.createNewHotel(order));
    }
}
