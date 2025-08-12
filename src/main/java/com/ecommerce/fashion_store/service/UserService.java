package com.ecommerce.fashion_store.service;


import com.ecommerce.fashion_store.dto.UserDTO;
import com.ecommerce.fashion_store.model.Cart;
import com.ecommerce.fashion_store.model.User;
import com.ecommerce.fashion_store.repository.CartRepository;
import com.ecommerce.fashion_store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CartRepository cartRepository;

    private final JWTService jwtService;

    public void signup(UserDTO userDTO){

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }

    public String login(UserDTO userDTO){

        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());
        if (user.isEmpty()){
            throw new UsernameNotFoundException("Invalid username");
        }

        if (!passwordEncoder.matches(userDTO.getPassword(),user.get().getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return jwtService.getJWTToken(userDTO.getUsername());

    }
}
