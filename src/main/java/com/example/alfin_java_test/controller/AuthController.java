package com.example.alfin_java_test.controller;

import com.example.alfin_java_test.security.JwtUtil;
import com.example.alfin_java_test.security.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody UserCredentials creds) {
        if ("user".equals(creds.getUsername()) && "password".equals(creds.getPassword())) {
            String token = jwtUtil.generateToken(creds.getUsername());
            return Mono.just(ResponseEntity.ok(token));
        }
        return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
