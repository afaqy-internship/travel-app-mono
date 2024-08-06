package com.afaqy.internship.travelapp.adapters.rest;

import com.afaqy.internship.ordermanagement.representation.OrderRepresentation;
import com.afaqy.internship.ordermanagement.domain.entity.Order;
import com.afaqy.internship.ordermanagement.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderApiDelegate {

    private final OrderService orderService;

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
    public ResponseEntity<Order> newOrder(@RequestBody OrderRepresentation order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.orderService.createNewOrder(OrderRepresentation.toEntity(order)));
    }
}
