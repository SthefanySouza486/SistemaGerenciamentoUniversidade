package com.example.university.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"escritorio", "curso"})
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private LocalDate dataContratacao;

    @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Escritorio escritorio;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "professor_cursos",
            joinColumns = {@JoinColumn(name = "professor_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")})
    private Set<Curso> cursos = new HashSet<>();


    public void setEscritorio(Escritorio escritorio){
        if(escritorio != null){
            escritorio.setProfessor(this);
        }
        this.escritorio = escritorio;
    }

    public void addCurso(Curso curso){
        this.cursos.add(curso);
        curso.getProfessores().remove(this);
    }

    public void removeCurso(Curso curso){
        this.cursos.remove(curso);
        curso.getProfessores().remove(this);
    }

}
