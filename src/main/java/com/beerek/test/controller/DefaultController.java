package com.beerek.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @RequestMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello!");
    }

    @RequestMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("home/pong");
    }
}
