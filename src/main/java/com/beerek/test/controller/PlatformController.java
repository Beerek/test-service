package com.beerek.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformController {

    @RequestMapping("/platform/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
