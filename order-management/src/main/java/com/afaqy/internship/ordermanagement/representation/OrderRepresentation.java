package com.afaqy.internship.ordermanagement.representation;

import com.afaqy.internship.flightbooking.domain.entity.Flight;
import com.afaqy.internship.hotelbooking.domain.entity.Hotel;
import com.afaqy.internship.ordermanagement.domain.entity.Order;

public record OrderRepresentation(String fromAirport, String toAirport, Integer nights) {
    public static Order toEntity(OrderRepresentation orderRepresentation) {
        Order order = new Order();
        Flight flight = new Flight();
        Hotel hotel = new Hotel();

        flight.setFromAirport(orderRepresentation.fromAirport());
        flight.setToAirport(orderRepresentation.toAirport());
        hotel.setNights(orderRepresentation.nights());

        order.setFlight(flight);
        order.setHotel(hotel);

        return order;
    }
}
