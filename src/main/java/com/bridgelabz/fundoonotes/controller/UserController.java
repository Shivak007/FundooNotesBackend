package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.request.*;
import com.bridgelabz.fundoonotes.dto.response.*;
import com.bridgelabz.fundoonotes.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(
            @Valid @RequestBody UserRegisterRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto) {

        return ResponseEntity.ok(service.login(dto));
    }
}