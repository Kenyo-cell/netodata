package org.example.service;

import org.example.entity.CustomerEntity;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<CustomerEntity> getProduct(String name) {
        return repository.getProductName(name);
    }
}
