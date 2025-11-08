package com.wcarvalho.course.respositories;

import com.wcarvalho.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
