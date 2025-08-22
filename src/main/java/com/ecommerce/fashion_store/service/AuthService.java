package com.ecommerce.fashion_store.service;

import com.ecommerce.fashion_store.config.JwtUtil;
import com.ecommerce.fashion_store.model.User;
import com.ecommerce.fashion_store.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(String username, String email,String password) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));

        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("user ===== "+user.getId());
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(username);
    }
}
