package org.example.controller;

import org.example.entity.CustomerEntity;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<CustomerEntity> getProduct(@RequestParam String name) {
        return service.getProduct(name);
    }
}
