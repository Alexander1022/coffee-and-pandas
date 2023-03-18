package com.fmi.entertizer.service;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.security.Signature;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService  {

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

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
}
