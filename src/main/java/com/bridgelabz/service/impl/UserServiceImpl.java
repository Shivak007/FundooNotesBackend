package com.bridgelabz.service.impl;

import com.bridgelabz.dto.request.UserRegistrationDTO;
import com.bridgelabz.entity.User;
import com.bridgelabz.exception.UserException;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.service.UserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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
        user.setPassword(dto.getPassword());

        return userRepository.save(user);
    }
}
