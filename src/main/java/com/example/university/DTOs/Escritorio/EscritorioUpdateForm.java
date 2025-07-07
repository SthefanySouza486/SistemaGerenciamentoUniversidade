package com.example.university.DTOs.Escritorio;

import jakarta.validation.constraints.Size;

public record EscritorioUpdateForm(
        @Size(min = 1)
        String numeroSala) {}
