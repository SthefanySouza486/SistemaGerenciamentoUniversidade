package com.example.university.Impl;

import com.example.university.DTOs.Professor.ProfessorCreateForm;
import com.example.university.DTOs.Professor.ProfessorUpdateForm;
import com.example.university.Entidades.Professor;
import com.example.university.Repository.ProfessorRepository;
import com.example.university.Services.ProfessorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository repository, ProfessorRepository professorRepository) {
        this.repository = repository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor create (ProfessorCreateForm form) {
        repository.findByEmail(form.email())
                .ifPresent(p -> {throw new IllegalArgumentException("Email de professor ja existente");
        });
        Professor professor = new Professor();
        professor.setName(form.nome());
        professor.setEmail(form.email());
        professor.setDataContratacao(form.dataContratacao());
        return repository.save(professor);
    }

    @Override
    public Professor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com id " + id));
    }

    @Override
    public List<Professor> findAll(){
        return repository.findAll();
    }

    @Override
    public Professor update(Long id, ProfessorUpdateForm form){
        Professor professor = findById(id);
        if(form.nome() != null && !form.nome().isBlank()){
            professor.setName(form.nome());
        }
        if(form.email() != null && !form.email().isBlank()){
            professor.setEmail(form.email());
        }
        if(form.dataContratacao() != null){
            professor.setDataContratacao(form.dataContratacao());
        }
        return repository.save(professor);
    }

    @Override
    public void delete(Long id){
        if(!professorRepository.existsById(id)){
            throw new EntityNotFoundException("Professor não encontrado com id " + id);
        }
        repository.deleteById(id);
    }

}
