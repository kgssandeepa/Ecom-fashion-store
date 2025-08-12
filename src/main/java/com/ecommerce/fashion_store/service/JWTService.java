package com.ecommerce.fashion_store.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {

    private final SecretKey secretKey;

    public JWTService(){
        try{
            SecretKey k= KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String getJWTToken(String username){

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*15))
                .signWith(secretKey)
                .compact();
    }

    public String getUsername(String token){

        try {



            return
                    Jwts.parser()
                            .verifyWith(secretKey)
                            .build()
                            .parseSignedClaims(token)
                            .getPayload()
                            .getSubject();
        } catch (Exception e) {
            return "invalid token";
        }
    }

//    public boolean isTokenValid(String token, UserDetails userDetails){
//
//    }
}
