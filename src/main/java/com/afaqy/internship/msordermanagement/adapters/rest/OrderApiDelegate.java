package com.afaqy.internship.msordermanagement.adapters.rest;

import com.afaqy.internship.msordermanagement.domain.entity.Order;
import com.afaqy.internship.msordermanagement.domain.service.FlightService;
import com.afaqy.internship.msordermanagement.domain.service.HotelService;
import com.afaqy.internship.msordermanagement.domain.service.OrderService;
import com.afaqy.internship.msordermanagement.representation.FlightRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.HotelRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.OrderRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.OrderResponseRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderApiDelegate {

    private final OrderService orderService;
    private final FlightService flightService;
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok().body(this.orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") Long id) {
        var order = this.orderService.getOrder(id);
        return order.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderResponseRepresentation> newOrder(@RequestBody
    OrderRequestRepresentation orderRequestRepresentation) {

        var flight = flightService.create(new FlightRequestRepresentation(orderRequestRepresentation.fromAirport(), orderRequestRepresentation.toAirport()));
        var hotel = hotelService.create(new HotelRequestRepresentation(orderRequestRepresentation.nights()));
        var order = orderService.createNewOrder(flight.id(), hotel.id());

        var orderRepresentationResponse = new OrderResponseRepresentation(order.getId(), flight.fromAirport(), flight.toAirport(), hotel.nights());

        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepresentationResponse);
    }
}
