package com.polozov.spring2.lesson06.integration;

import com.polozov.spring2.lesson06.domain.Order;
import com.polozov.spring2.lesson06.service.OrderService;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderActivator {

    private final OrderService orderService;

    public OrderActivator(OrderService orderService) {
        this.orderService = orderService;
    }

    @ServiceActivator(inputChannel = "ordersChannel")
    public void listenNewsChannel(@Payload Order payload, @Headers Map<String,Object> headers){
        System.out.println("Get order in message: " + payload);
        orderService.save(payload);
    }
}
