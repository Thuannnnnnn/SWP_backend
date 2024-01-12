package com.swp391.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class JwtUtil {

    private SecretKey secretKey;

    public JwtUtil(String secret) {
        // Create a SecretKey from the provided secret
        byte[] decodedSecret = Base64.getDecoder().decode(secret);
        this.secretKey = new SecretKeySpec(decodedSecret, SignatureAlgorithm.HS256.getJcaName());
        System.out.println(this.secretKey);
    }

    public Claims decodeJWT(String jwtToken) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken);

            return jws.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid JWT token", e);
        }
    }
}
