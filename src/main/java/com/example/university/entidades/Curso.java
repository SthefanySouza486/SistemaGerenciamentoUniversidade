package com.example.university.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal valorMensalidade;

    @OneToMany(mappedBy = "curso", CascadeType.ALL)
    @JsonIgnore
    private Set<Matricula> matriculas = new HashSet<>();


}
