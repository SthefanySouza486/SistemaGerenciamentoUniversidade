package com.example.university.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
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

    public void setEscritorio(Escritorio escritorio){
        if(escritorio != null){
            escritorio.setProfessor(this);
        }
        this.escritorio = escritorio;
    }

}
