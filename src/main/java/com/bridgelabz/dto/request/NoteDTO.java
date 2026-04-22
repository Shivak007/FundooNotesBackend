package com.bridgelabz.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String color = "#FFFFFF";
}