package com.example.university.Entidades;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class IdMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long studentId;
    private Long cursoId;
}
