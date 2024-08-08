package com.afaqy.internship.mshotelbooking.infrastructure;

import com.afaqy.internship.mshotelbooking.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
