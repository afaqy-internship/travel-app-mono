package com.afaqy.internship.hotelbooking.infrastructure;

import com.afaqy.internship.hotelbooking.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
