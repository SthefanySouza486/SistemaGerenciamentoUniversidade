package com.example.university.Repository;

import com.example.university.Entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByIdIn(List<Long> ids);
    List<Curso> findByValorMensalidadeGreaterThan(BigDecimal valorMensalidade);
    List<Curso> findByValorMensalidadeGreaterThanEqual(BigDecimal valorMensalidade);
    List<Curso> findByValorMensalidadeLessThan(BigDecimal valorMensalidade);
    List<Curso> findByValorMensalidadeLessThanEqual(BigDecimal valorMensalidade);
}
