package com.example.Giftora.controllers;





import com.example.Giftora.dto.AuthRequest;
import com.example.Giftora.dto.AuthResponse;
import com.example.Giftora.entities.User;
import com.example.Giftora.repositories.UserRepository;
import com.example.Giftora.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest req) {
        if (req.getEmail() == null || req.getPassword() == null || req.getRole() == null) {
            return ResponseEntity.badRequest().body("Email, password and role are required");
        }

        Optional<User> existing = Optional.ofNullable(userRepository.findByEmail(req.getEmail()));
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("User with that email already exists");
        }

        User user = new User();
        user.setName(req.getName() == null ? "" : req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword())); // hash
        user.setRole(req.getRole().toUpperCase()); // e.g., BUYER or SELLER

        User saved = userRepository.save(user);

        String token = jwtUtil.generateToken(saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new AuthResponse(token, saved.getRole(), saved.getEmail()));
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        if (req.getEmail() == null || req.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password required");
        }

        User user = userRepository.findByEmail(req.getEmail());
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        boolean matches = passwordEncoder.matches(req.getPassword(), user.getPassword());
        if (!matches) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return ResponseEntity.ok(new AuthResponse(token, user.getRole(), user.getEmail()));
    }
}
