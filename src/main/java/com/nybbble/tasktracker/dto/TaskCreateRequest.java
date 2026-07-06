package com.nybbble.tasktracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskCreateRequest(

        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must be shorter than 100 characters")
        String title,

        @Size(max = 500, message = "Description must be shorter than 500 characters")
        String description
) {
}
