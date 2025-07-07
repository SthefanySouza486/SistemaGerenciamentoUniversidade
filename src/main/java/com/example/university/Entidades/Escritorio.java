package com.example.university.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Escritorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroSala;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", unique = true)
    @JsonBackReference
    @ToString.Exclude
    private Professor professor;
}
