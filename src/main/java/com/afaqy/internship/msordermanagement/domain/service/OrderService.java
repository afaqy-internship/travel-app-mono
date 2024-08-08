package com.afaqy.internship.msordermanagement.domain.service;

import com.afaqy.internship.msordermanagement.domain.entity.Order;
import com.afaqy.internship.msordermanagement.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Order> getOrder(Long id) {
        return this.orderRepository.findById(id);
    }

    @Transactional
    public Order createNewOrder(Long flightId, Long hotelId) {

        var order = new Order();
        order.setFlightId(flightId);
        order.setHotelId(hotelId);

        return this.orderRepository.save(order);
    }
}
