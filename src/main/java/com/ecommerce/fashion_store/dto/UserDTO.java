package com.ecommerce.fashion_store.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private String username;
    private String email;
    private String password;


}

