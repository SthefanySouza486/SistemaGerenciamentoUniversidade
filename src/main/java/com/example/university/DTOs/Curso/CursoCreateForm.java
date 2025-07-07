package com.example.university.DTOs.Curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CursoCreateForm(
        @NotBlank
        @Size(min = 3)
        String nome,

        @Positive
        BigDecimal valorMensalidade
        ) {
}
