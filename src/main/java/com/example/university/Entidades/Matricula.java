package com.example.university.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Matricula {

    @EmbeddedId
    private IdMatricula id = new IdMatricula();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentsId")
    @JoinColumn(name = "student_id")
    private Estudante estudante;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime dataMatricula;

    @Enumerated(EnumType.STRING)
    private Notas notas;
}
