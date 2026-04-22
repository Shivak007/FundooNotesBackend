package com.bridgelabz.controller;

import com.bridgelabz.dto.request.UserRegistrationDTO;
import com.bridgelabz.dto.response.ResponseDTO;
import com.bridgelabz.entity.User;
import com.bridgelabz.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO userDTO) {
        log.info("Received request to register user: {}", userDTO.getEmail());

        User user = userService.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User registered successfully", user.getId());

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}