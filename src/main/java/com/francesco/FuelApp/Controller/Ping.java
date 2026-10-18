package com.francesco.FuelApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

@RestController 
@RequestMapping("/ping")
public class Ping 
{
    @GetMapping
    public ResponseEntity<String> ping() 
    {
        return ResponseEntity.ok("pong");
    }
    
}
