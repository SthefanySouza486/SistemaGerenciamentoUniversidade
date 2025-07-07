package com.example.university.DTOs.Estudante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudanteCreateForm(
        @NotBlank (message = "O nome não pode estar em branco!")
        @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres.")
        String nome) {}
