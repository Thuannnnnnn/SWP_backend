package com.swp391.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user", "/index", "/api/Users", "/oauth2/user").authenticated()
                .anyRequest().permitAll()
            )
            .oauth2Login(oauth2Login -> oauth2Login
                .loginPage("/oauth2/authorization/google")
                .permitAll())
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/index"));

        // You can add additional configurations for JWT-based authentication here
        // For example:
        // .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)

        return http.build();
    }

    // Define your JwtService bean if needed
    // @Bean
    // public JwtService jwtService() {
    //     return new JwtService();
    // }

    // Define your JwtTokenFilter bean if needed
    // @Bean
    // public JwtTokenFilter jwtTokenFilter() {
    //     return new JwtTokenFilter(jwtService());
    // }
}
