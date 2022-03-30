package org.example.controller;

import org.example.service.JdbcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcController {
    private final JdbcService service;

    public JdbcController(JdbcService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<String> getProduct(@RequestParam String name) {
        return service.getProduct(name);
    }
}
