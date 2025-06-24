package com.example.alfin_java_test.security;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class JwtReactiveAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtil jwtUtil;

    public JwtReactiveAuthenticationManager(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String token = authentication.getCredentials().toString();
        try {
            String username = jwtUtil.validateTokenAndGetUser(token);
            // Aquí defines roles/granted authorities
            List<SimpleGrantedAuthority> authorities =
                    List.of(new SimpleGrantedAuthority("ROLE_USER"));
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
            return Mono.just(auth);
        } catch (Exception e) {
            return Mono.empty();
        }
    }
}