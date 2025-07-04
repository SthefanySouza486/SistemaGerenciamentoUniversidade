package com.example.university.entidades;

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
public class IdComposto implements Serializable {

    private static final long serialVersionUID = 1L;//mecanismo de segurança que garante que você não carregue dados
    // de uma versão antiga e incompatível de uma classe, prevenindo bugs e corrupção de dados. Para classes de ID
    // composto em JPA como esta, a serialização é um requisito da especificação.
    private Long studentId;
    private Long cursoId;
}
