package com.example.university.Repository;

import com.example.university.Entidades.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    Optional<Estudante> findByNome(String nome);
    Optional<Estudante> findFirstByOrderByNomeAsc();
    List<Estudante> findByOrderByNomeDesc();
}
