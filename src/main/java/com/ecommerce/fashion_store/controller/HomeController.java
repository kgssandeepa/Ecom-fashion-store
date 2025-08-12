package com.ecommerce.fashion_store.controller;


import com.ecommerce.fashion_store.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JWTService jwtService;


    @GetMapping
    public String getHello(){
        return "hi";
    }
    @PostMapping("/login")
    public String login(){
        return jwtService.getJWTToken("");
    }
    @GetMapping("/username")
    public String getUsername(@RequestParam String token){
        return jwtService.getUsername(token);
    }
}
