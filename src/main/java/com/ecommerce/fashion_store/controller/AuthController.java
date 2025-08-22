package com.ecommerce.fashion_store.controller;


import com.ecommerce.fashion_store.dto.UserDTO;
import com.ecommerce.fashion_store.dto.UserLoginDTO;
import com.ecommerce.fashion_store.service.AuthService;
import com.ecommerce.fashion_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userDTO) {
        userService.signup(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginDTO loginDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            String token = authService.login(loginDTO.getUsername(), loginDTO.getEmail(), loginDTO.getPassword());
            response.put("success", true);
            response.put("token", token);

            System.out.println("response ==== "+response);
            return ResponseEntity.ok(response); // returns JSON
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("errors", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
