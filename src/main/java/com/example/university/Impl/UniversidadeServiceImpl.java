package com.example.university.Impl;

import com.example.university.Entidades.Curso;
import com.example.university.Entidades.Professor;
import com.example.university.Repository.CursoRepository;
import com.example.university.Repository.ProfessorRepository;
import com.example.university.Services.UniversidadeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UniversidadeServiceImpl implements UniversidadeService {

    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;

    public UniversidadeServiceImpl(ProfessorRepository professorRepository, CursoRepository cursoRepository) {
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    @Transactional
    public void assignProfessorToCourse(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com id " + professorId));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com id " + cursoId));

        professor.addCurso(curso);
        professorRepository.save(professor);
    }

    @Override
    @Transactional
    public void removeProfessorFromCourse(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com id " + professorId));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com id" + cursoId));

        professor.removeCurso(curso);
        professorRepository.save(professor);
    }
}
