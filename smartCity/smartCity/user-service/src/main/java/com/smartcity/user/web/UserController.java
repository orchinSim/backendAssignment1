package com.smartcity.user.web;

import com.smartcity.user.dto.LoginRequest;
import com.smartcity.user.dto.LoginResponse;
import com.smartcity.user.dto.RegisterRequest;
import com.smartcity.user.model.User;
import com.smartcity.user.repo.UserRepository;
import com.smartcity.user.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserRepository users;
    private final JwtService jwt;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserController(UserRepository users, JwtService jwt) {
        this.users = users; this.jwt = jwt;
    }

    @Value("${spring.application.name:user-service}")
    private String appName;

    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String,Object> register(@Valid @RequestBody RegisterRequest req) {
        if (users.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        if (users.existsByPhone(req.getPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone already exists");
        }
        User u = new User();
        u.setEmail(req.getEmail());
        u.setPhone(req.getPhone());
        u.setName(req.getName());
        u.setPasswordHash(encoder.encode(req.getPassword()));
        users.save(u);
        return Map.of("id", u.getId(), "email", u.getEmail(), "name", u.getName());
    }

    @PostMapping("auth/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        User u = users.findByEmail(req.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));
        if (!encoder.matches(req.getPassword(), u.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        String token = jwt.generateToken(
                String.valueOf(u.getId()),
                Map.of("email", u.getEmail(), "name", u.getName())
        );
        return new LoginResponse(token);
    }

    // Handy health/info
    @GetMapping("actuator/ping")
    public Map<String,String> ping(){ return Map.of("service", appName, "status","ok"); }
}
