package com.ecommerce.fashion_store.controller;


import com.ecommerce.fashion_store.dto.UserDTO;
import com.ecommerce.fashion_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userDTO) {
        userService.signup(userDTO);
    }


    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

}
