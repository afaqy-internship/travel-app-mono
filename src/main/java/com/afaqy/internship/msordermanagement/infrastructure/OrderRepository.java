package com.afaqy.internship.msordermanagement.infrastructure;

import com.afaqy.internship.msordermanagement.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
