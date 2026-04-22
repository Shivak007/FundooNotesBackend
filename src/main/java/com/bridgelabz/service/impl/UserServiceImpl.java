package com.bridgelabz.service.impl;

import com.bridgelabz.dto.request.UserRegistrationDTO;
import com.bridgelabz.entity.User;
import com.bridgelabz.dto.request.UserLoginDTO;
import com.bridgelabz.exception.UserException;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.service.UserService;
import org.springframework.stereotype.Service;
import com.bridgelabz.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public User registerUser(UserRegistrationDTO dto) {
        Optional<User> existingUser = userRepository.findByEmail(dto.getEmail());
        if (existingUser.isPresent()) {
            throw new UserException("Email is already registered! Please login.");
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());

        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(user);
    }
    @Override
    public String loginUser(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UserException("User not found with this email"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UserException("Invalid Password");
        }

        return jwtUtil.generateToken(user.getId(), user.getEmail());
    }
}
