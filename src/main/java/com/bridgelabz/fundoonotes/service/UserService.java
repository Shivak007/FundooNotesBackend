package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.request.*;
import com.bridgelabz.fundoonotes.dto.response.*;

public interface UserService {
    UserResponseDto register(UserRegisterRequestDto dto);
    LoginResponseDto login(LoginRequestDto dto);
}