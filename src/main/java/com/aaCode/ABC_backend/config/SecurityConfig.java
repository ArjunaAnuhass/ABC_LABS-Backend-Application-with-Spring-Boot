package com.aaCode.ABC_backend.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/v1/authentication/register1").permitAll()
                        .requestMatchers("api/v1/authentication/authenticate").permitAll()
                        .requestMatchers("api/v1/authentication/register2").permitAll()
                        .requestMatchers("api/v1/authentication/register3").permitAll()
                        .requestMatchers("api/v1/authentication/getAllUsers").permitAll()
                        .requestMatchers("api/v1/technician/**").permitAll()
                        .requestMatchers("api/v1/patient/**").permitAll()
                        .requestMatchers("api/v1/doctor/**").permitAll()
                        .requestMatchers("api/v1/test/**").permitAll()
                        .requestMatchers("api/v1/appointment/**").permitAll()
                        .requestMatchers("api/v1/results/**").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
