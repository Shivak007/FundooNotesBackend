package com.bridgelabz.service;

import com.bridgelabz.dto.request.UserRegistrationDTO;
import com.bridgelabz.entity.User;

public interface UserService {
    User registerUser(UserRegistrationDTO dto);
}