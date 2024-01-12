package com.swp391.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class JwtService {

    private static final Logger LOGGER = Logger.getLogger(JwtService.class.getName());

    
    private String secretKey = "A12345";

    private static final long EXPIRATION_TIME = 30 *1000; // 30 minutes

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);

            Claims body = claims.getBody();
            String subject = body.getSubject();
          
            if (subject == null || subject.isEmpty()) {
                LOGGER.warning("Token validation failed: Subject is empty");
                return false;
            }	
            return true;
        } catch (ExpiredJwtException e) {
            LOGGER.warning("Token expired: " + token);
            return false;
        } catch (Exception e) {
            LOGGER.severe("Error validating token: " + token);
            e.printStackTrace();
            return false;
        }
    }
}
