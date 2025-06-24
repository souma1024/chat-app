package com.souma1024.chat.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .defaultSuccessUrl("/chat")
            .failureUrl("/login?error")
            .usernameParameter("loginId")
            .permitAll()
            ).logout(logout -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/")
                .permitAll()
            ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()//静的ファイルはすべて許可
                .requestMatchers("/", "/login", "/signup").permitAll()
                .anyRequest().authenticated() //  他のURLはログイン後アクセス可能
        );

        return http.build();
    }
}
