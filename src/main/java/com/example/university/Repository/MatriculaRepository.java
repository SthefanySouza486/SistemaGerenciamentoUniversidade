package com.example.university.Repository;

import com.example.university.Entidades.IdMatricula;
import com.example.university.Entidades.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, IdMatricula> {
    List<Matricula> findByEstudanteId(Long estudanteId);
    List<Matricula> findByCursoId(Long cursoId);
    List<Matricula> findByMatriculaDateAfter(LocalDateTime data);
}
