package com.souma1024.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
            .loginPage("/login")
            .permitAll())
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**").permitAll() // CSSファイルは認証不要で使えるようにする
                .requestMatchers("/login").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/login-process").permitAll()
                .requestMatchers("/").permitAll() //  トップページは認証不要
                .anyRequest().authenticated() //  他のURLはログイン後アクセス可能
        );

        return http.build();
    }
}
