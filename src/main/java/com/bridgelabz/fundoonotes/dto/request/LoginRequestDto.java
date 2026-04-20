package com.bridgelabz.fundoonotes.dto.request;

import lombok.*;

@Getter @Setter
public class LoginRequestDto {
    private String email;
    private String password;
}