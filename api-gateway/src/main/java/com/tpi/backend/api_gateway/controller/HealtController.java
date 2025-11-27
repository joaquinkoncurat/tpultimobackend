package com.tpi.backend.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealtController {

    @GetMapping("/health")
    public String health() {
        return "API Gateway funcionando OK";
    }
}
