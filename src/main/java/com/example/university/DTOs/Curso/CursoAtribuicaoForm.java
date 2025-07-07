package com.example.university.DTOs.Curso;

import jakarta.validation.constraints.NotNull;

public record CursoAtribuicaoForm(
        @NotNull
        Long professorId,

        @NotNull
        Long cursoId) {}
