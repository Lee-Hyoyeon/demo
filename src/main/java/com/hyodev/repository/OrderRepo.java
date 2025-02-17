package com.hyodev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hyodev.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{
        
}
