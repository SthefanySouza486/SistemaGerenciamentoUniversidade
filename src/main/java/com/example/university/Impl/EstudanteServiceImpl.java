package com.example.university.Impl;

import com.example.university.DTOs.Estudante.EstudanteCreateForm;
import com.example.university.DTOs.Estudante.EstudanteUpdateForm;
import com.example.university.Entidades.Estudante;
import com.example.university.Repository.EstudanteRepository;
import com.example.university.Services.EstudanteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudanteServiceImpl implements EstudanteService {
    private final EstudanteRepository repository;

    public EstudanteServiceImpl(EstudanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Estudante create (EstudanteCreateForm form){
        Estudante estudante = new Estudante();
        estudante.setNome(form.nome());
        return repository.save(estudante);
    }

    @Override
    public Estudante findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Estudante não encontrado com id " + id));
    }

    @Override
    public List<Estudante> findAll(){
        return repository.findAll();
    }

    @Override
    public Estudante update(Long id, EstudanteUpdateForm form) {
        Estudante estudante = findById(id);
        if(form.nome() != null && !form.nome().isBlank()){
            estudante.setNome(form.nome());
        }
        return repository.save(estudante);
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Estudante não encontrado com id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<String> getAllEstudanteNomesUpperCase() {
        return repository.findAll()
                .stream()
                .map(estudante -> estudante.getNome().toUpperCase())
                .collect(Collectors.toList());
    }
}
