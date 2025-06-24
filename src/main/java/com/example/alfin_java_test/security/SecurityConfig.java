package com.example.alfin_java_test.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtReactiveAuthenticationManager authManager;
    private final SecurityContextRepository contextRepository;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authenticationManager(authManager)
                .securityContextRepository(contextRepository)
                .authorizeExchange(ex -> ex
                        .pathMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .pathMatchers("/h2-console/**").permitAll()
                        .anyExchange().authenticated()
                )
                .headers(headers -> headers
                        .frameOptions(ServerHttpSecurity.HeaderSpec.FrameOptionsSpec::disable)
                );

        return http.build();
    }
}


