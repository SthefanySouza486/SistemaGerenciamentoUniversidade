package com.example.university.DTOs.Estudante;

import jakarta.validation.constraints.Size;

public record EstudanteUpdateForm (
        @Size(min = 2)
        String nome){}
