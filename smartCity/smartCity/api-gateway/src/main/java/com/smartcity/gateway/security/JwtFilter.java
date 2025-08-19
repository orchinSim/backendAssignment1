package com.smartcity.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(JwtFilter.class);
    private static final AntPathMatcher PATHS = new AntPathMatcher();

    @Value("${security.jwt.required:false}")
    private boolean jwtRequired;

    @Value("${security.jwt.secret:change-me}")
    private String jwtSecret;

    @Value("${security.jwt.permit-paths:/auth/**,/users}")
    private String permitPaths;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!jwtRequired) return chain.filter(exchange);

        String path = exchange.getRequest().getPath().value();
        List<String> permits = Arrays.stream(permitPaths.split(",")).map(String::trim).toList();
        for (String p : permits) {
            if (PATHS.match(p, path)) return chain.filter(exchange);
        }

        String auth = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (auth == null || !auth.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = auth.substring(7);
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            log.debug("JWT ok for subject={}", claims.getSubject());
            return chain.filter(exchange);
        } catch (Exception e) {
            log.warn("JWT invalid: {}", e.getMessage());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() { return -1; }
}
