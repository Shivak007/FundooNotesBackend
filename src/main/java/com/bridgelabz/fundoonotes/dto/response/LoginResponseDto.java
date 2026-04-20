package com.bridgelabz.fundoonotes.dto.response;

import lombok.*;

@AllArgsConstructor
@Getter
public class LoginResponseDto {
    private String token;
    private String message;
}