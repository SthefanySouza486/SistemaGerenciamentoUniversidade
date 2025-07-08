package com.example.university.Impl;

import com.example.university.DTOs.Escritorio.EscritorioCreateForm;
import com.example.university.DTOs.Escritorio.EscritorioUpdateForm;
import com.example.university.Entidades.Escritorio;
import com.example.university.Entidades.Professor;
import com.example.university.Repository.EscritorioRepository;
import com.example.university.Services.EscritorioService;
import com.example.university.Services.ProfessorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscritorioServiceImpl implements EscritorioService {

    private final EscritorioRepository repository;
    private final ProfessorService professorService;

    public  EscritorioServiceImpl(EscritorioRepository repository, ProfessorService professorService) {
        this.repository = repository;
        this.professorService = professorService;
    }

    @Override
    @Transactional
    public Escritorio create (EscritorioCreateForm form){
        Professor professor = professorService.findById(form.professorId());
        if(professor.getEscritorio() != null){
            throw new IllegalArgumentException("Professor ja possui um Escritorio");
        }
        Escritorio escritorio = new Escritorio();
        escritorio.setNumeroSala(form.numeroSala());
        professor.setEscritorio(escritorio);
        return professor.getEscritorio();
    }

    @Override
    public Escritorio findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Escritório não encontrado com id " + id));
    }

    @Override
    public List<Escritorio>  findAll() {
        return repository.findAll();
    }

    @Override
    public Escritorio update (Long id, EscritorioUpdateForm form){
        Escritorio escritorio = findById(id);
        if(form.numeroSala() != null && !form.numeroSala().isBlank()){
            escritorio.setNumeroSala(form.numeroSala());
        }
        return repository.save(escritorio);
    }

    @Override
    public void delete (Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Escritorio não encontrado com id " + id);
        }
        repository.deleteById(id);
    }
}
