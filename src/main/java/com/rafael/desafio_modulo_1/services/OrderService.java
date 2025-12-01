package com.rafael.desafio_modulo_1.services;

import com.rafael.desafio_modulo_1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shipment;

    public double total(Order order){
        double decimalDiscount = order.getDiscount()/100;
        return order.getBasic() - (order.getBasic() * decimalDiscount) + shipment.shipment(order);
    }
}
