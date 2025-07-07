package com.example.university.DTOs.Professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ProfessorCreateForm(
        @NotBlank
        @Size(min = 2)
        String nome,

        @NotBlank
        @Email
        String email,

        @PastOrPresent
        LocalDate dataContratacao) {}
