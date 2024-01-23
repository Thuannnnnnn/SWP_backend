package com.swp391.config;
import org.springframework.web.filter.OncePerRequestFilter;

import com.swp391.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Collections;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class JwtTokenFilter extends OncePerRequestFilter {

    // Giả sử bạn có một service để xử lý JWT
    private JwtService jwtService;

    public JwtTokenFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); 

            try {
                String username = jwtService.generateToken(token);
                if (username != null) {
                	if(jwtService.validateToken(token)) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, null, Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }}
            } catch (Exception e) {
                // Xử lý trường hợp token không hợp lệ
            }
        }

        filterChain.doFilter(request, response);
    }
}
