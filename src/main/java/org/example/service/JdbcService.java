package org.example.service;

import org.example.repository.JdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcService {
    private final JdbcRepository repository;

    public JdbcService(JdbcRepository repository) {
        this.repository = repository;
    }

    public List<String> getProduct(String name) {
        return repository.getProductName(name);
    }
}
