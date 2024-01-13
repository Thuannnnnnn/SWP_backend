package com.swp391.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.swp391.service.JwtService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
    private JwtService jwtService;
	

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/user", "/index","/api/Users","/oauth2/user").authenticated()
	            .anyRequest().permitAll()
	        )
	        .oauth2Login(oauth2Login -> oauth2Login
	            .loginPage("/oauth2/authorization/google")
	            .permitAll())
	        .logout(logout -> logout
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutSuccessUrl("/index"))
	        .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // Thêm filter JWT
	    return http.build();
	}

	@Bean
	public JwtTokenFilter jwtTokenFilter() {
	    return new JwtTokenFilter(jwtService);
	}
}