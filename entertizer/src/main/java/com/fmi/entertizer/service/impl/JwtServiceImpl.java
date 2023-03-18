package com.fmi.entertizer.service.impl;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtServiceImpl {

    public static final String SECRET = "4A404E635266556A586E3272357538782F413F4428472B4B6250645367566B59";
    public String generateToken(String email){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,email);
    }

    private String createToken(Map<String ,Object> claims, String email){
        Gson gson = new Gson();
         return Jwts.builder()
                 .setClaims(claims)
                 .setSubject(email)
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                 .serializeToJsonWith(new GsonSerializer(gson))
                 .signWith(SignatureAlgorithm.HS256, getSignKey()).compact();
    }

    private Key getSignKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
