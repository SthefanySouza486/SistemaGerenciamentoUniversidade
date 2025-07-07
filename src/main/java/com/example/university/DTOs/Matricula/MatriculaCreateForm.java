package com.example.university.DTOs.Matricula;

import jakarta.validation.constraints.NotNull;

public record MatriculaCreateForm(
        @NotNull
        Long estudanteId,

        @NotNull
        Long cursoId) {}
