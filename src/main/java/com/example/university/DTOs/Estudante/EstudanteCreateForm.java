package com.example.university.DTOs.Estudante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudanteCreateForm(
        @NotBlank ()
        @Size(min = 2)
        String nome) {}
