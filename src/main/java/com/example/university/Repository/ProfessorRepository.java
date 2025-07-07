package com.example.university.Repository;

import com.example.university.Entidades.Professor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmail(String email);
    Optional<Professor> findByNameAndEmail(String nome, String email);
    List<Professor> findByNameOrEmail(String nome, String email);
    List<Professor> findByDataContratacaoBetween(LocalDate comeco, LocalDate fim);
    List<Professor> findByNameOrderByDataContratacaoDesc(String nome);

    @Transactional
    void deleteByEmail(String email);
}
