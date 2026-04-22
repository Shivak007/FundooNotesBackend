package com.bridgelabz.config;
import com.bridgelabz.dto.request.UserLoginDTO;
import com.bridgelabz.dto.request.UserRegistrationDTO;
import com.bridgelabz.entity.User;

public interface UserService {
    User registerUser(UserRegistrationDTO dto);

    String loginUser(UserLoginDTO dto);
}
