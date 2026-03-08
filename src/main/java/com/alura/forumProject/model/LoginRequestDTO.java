package com.alura.forumProject.model;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(@NotBlank String user, @NotBlank String password) {
}
