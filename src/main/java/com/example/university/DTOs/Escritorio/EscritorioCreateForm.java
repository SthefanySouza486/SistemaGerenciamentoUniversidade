package com.example.university.DTOs.Escritorio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EscritorioCreateForm(
        @NotBlank
        @Size(min = 1)
        String numeroSala,

        @NotNull
        Long professorId) {}
