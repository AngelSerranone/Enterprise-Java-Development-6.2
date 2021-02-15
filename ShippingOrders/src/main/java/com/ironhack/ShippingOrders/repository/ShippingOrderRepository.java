package com.ironhack.ShippingOrders.repository;

import com.ironhack.ShippingOrders.model.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
}
