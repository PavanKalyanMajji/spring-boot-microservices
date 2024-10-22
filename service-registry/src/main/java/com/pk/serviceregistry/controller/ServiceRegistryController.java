package com.pk.serviceregistry.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/serviceregistry/")
public class ServiceRegistryController {
    @GetMapping("ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Success");
    }
}
