package com.practice.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        log.info("checkHealth");
        return ResponseEntity.ok("Service up");
    }
}
