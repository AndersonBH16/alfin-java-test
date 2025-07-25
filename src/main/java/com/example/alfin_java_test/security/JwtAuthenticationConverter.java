package com.example.alfin_java_test.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtAuthenticationConverter implements ServerAuthenticationConverter {
    private final JwtUtil jwtUtil;

    public JwtAuthenticationConverter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return Mono.empty();
        }

        String token = authHeader.substring(7);
        try {
            String username = jwtUtil.validateTokenAndGetUser(token);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    new User(username, "", List.of(new SimpleGrantedAuthority("ROLE_USER"))),
                    token,
                    List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
            return Mono.just(auth);
        } catch (Exception e) {
            return Mono.empty();
        }
    }
}