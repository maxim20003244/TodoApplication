package com.example.mycompany.todoapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurity (HttpSecurity httpSecurity) throws Exception {
         httpSecurity.authorizeHttpRequests()
                 .requestMatchers("/home","","/").permitAll()
                 .requestMatchers("/list-todo/**").authenticated()
                 .requestMatchers("/dist/**").permitAll()
                 .requestMatchers("/webjars/**","/js/**","/css/**").permitAll()
                 .requestMatchers("/add-todo").authenticated()
                 .and().formLogin()
                 .and().httpBasic();
        return httpSecurity.build();
    }

}
