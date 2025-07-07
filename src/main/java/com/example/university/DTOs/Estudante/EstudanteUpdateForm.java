package com.example.university.DTOs.Estudante;

import jakarta.validation.constraints.Size;

public record EstudanteUpdateForm (
        @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres.")
        String nome){}
