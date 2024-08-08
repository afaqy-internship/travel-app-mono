package com.afaqy.internship.msordermanagement.infrastructure;

import com.afaqy.internship.msordermanagement.representation.HotelRequestRepresentation;
import com.afaqy.internship.msordermanagement.representation.HotelResponseRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "HotelService", url = "${apis.ms-hotel}/hotels")
public interface HotelRepository {

    @PostMapping
    ResponseEntity<HotelResponseRepresentation> newHotel(@RequestBody
    HotelRequestRepresentation hotelRequestRepresentation);
}
