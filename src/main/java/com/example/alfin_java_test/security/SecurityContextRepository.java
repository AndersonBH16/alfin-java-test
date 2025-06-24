package com.example.alfin_java_test.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private final ServerAuthenticationConverter jwtConverter;

    public SecurityContextRepository(ServerAuthenticationConverter jwtConverter) {
        this.jwtConverter = jwtConverter;
    }

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        // No se usa en JWT stateless
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        return jwtConverter.convert(exchange)
                .map(SecurityContextImpl::new);
    }
}
