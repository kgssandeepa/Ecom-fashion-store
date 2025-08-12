package com.ecommerce.fashion_store.service;


import com.ecommerce.fashion_store.dto.UserDTO;
import com.ecommerce.fashion_store.model.Cart;
import com.ecommerce.fashion_store.model.User;
import com.ecommerce.fashion_store.repository.CartRepository;
import com.ecommerce.fashion_store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final CartRepository cartRepository;

    public void signup(UserDTO userDTO){

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }
}
