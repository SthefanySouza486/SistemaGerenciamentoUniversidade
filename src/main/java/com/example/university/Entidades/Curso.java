package com.example.university.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"professores", "matriculas"})
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal valorMensalidade;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Matricula> matriculas = new HashSet<>();

    @ManyToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Professor> professores = new HashSet<>();


}
