package com.beerek.test.controller;

import com.beerek.test.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

@RestController
public class DefaultController {

    private final ReaderService readerService;

    @Autowired
    public DefaultController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @RequestMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello!");
    }

    @RequestMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @RequestMapping("/**")
    public Callable<ResponseEntity<String>> defaultBehavior(HttpServletRequest request) {
        return () ->
            readerService.readByUrl(request.getRequestURI())
                    .map(ResponseEntity::ok)
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
