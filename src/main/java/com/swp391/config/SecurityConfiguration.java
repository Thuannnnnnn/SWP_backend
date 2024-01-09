package com.swp391.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/css/**");
	}

	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests((authorize) -> authorize
	            .requestMatchers("/a").authenticated() // Yêu cầu xác thực cho /Users
	            .anyRequest().permitAll() // Cho phép tất cả các yêu cầu khác mà không cần xác thực
	        )
	        .formLogin((formLogin) -> formLogin
	            .loginPage("/api/signIn") // Trang đăng nhập tùy chỉnh
	            // Không cần chỉ định defaultSuccessUrl
	            .failureUrl("/error") 	           
	            
	            );

	    return http.build();
	}


}