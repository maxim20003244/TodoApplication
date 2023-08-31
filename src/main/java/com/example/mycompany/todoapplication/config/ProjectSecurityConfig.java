package com.example.mycompany.todoapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurity (HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                 .requestMatchers("/home","","/").permitAll()
                 .requestMatchers("/list-todo").permitAll()
                 .requestMatchers("/dist/**").permitAll()
                 .requestMatchers("/webjars/**","/js/**","/css/**","/assets/**").permitAll()
                 .requestMatchers("/delete-todo").authenticated()
                 .requestMatchers("/edit-todo").authenticated()
                 .requestMatchers("/add-todo/**").permitAll()
                 .requestMatchers("/save-todo/**").authenticated()
                 .requestMatchers("/save-editTodo/**").authenticated()
                 .requestMatchers("/login").permitAll()
                 .requestMatchers("/logout").permitAll()
                 .requestMatchers("/public/**").permitAll()
                 .requestMatchers("/createUser").permitAll()
                 .requestMatchers("/register").permitAll()
                 .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/list-todo").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

        return http.build();
    }

}
