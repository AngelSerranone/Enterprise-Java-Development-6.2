package com.ironhack.ShippingOrders.controller.interfaces;

import com.ironhack.ShippingOrders.model.ShippingOrder;
import org.springframework.web.bind.annotation.PathVariable;

public interface IShippingOrderController {

    public ShippingOrder getShippingOrderById(Integer id);
}
