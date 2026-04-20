package com.bridgelabz.fundoonotes.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
public class UserRegisterRequestDto {

    @NotBlank
    private String firstName;

    @Email
    private String email;

    @NotBlank
    private String password;
}