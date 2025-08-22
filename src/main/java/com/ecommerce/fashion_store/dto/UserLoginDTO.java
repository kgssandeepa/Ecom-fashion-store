package com.ecommerce.fashion_store.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserLoginDTO {

    private String email;
    private String username;
    private String password;
}
