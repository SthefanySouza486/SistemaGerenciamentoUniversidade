package com.example.university.Impl;

import com.example.university.DTOs.Curso.CursoCreateForm;
import com.example.university.DTOs.Curso.CursoUpdateForm;
import com.example.university.Entidades.Curso;
import com.example.university.Repository.CursoRepository;
import com.example.university.Services.CursoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Curso create(CursoCreateForm form) {
        Curso curso = new Curso();
        curso.setNome(form.nome());
        curso.setValorMensalidade(form.valorMensalidade());
        return repository.save(curso);
    }

    @Override
    public Curso findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Curso não encontrado com id " + id));
    }

    @Override
    public List<Curso> findAll() {
        return repository.findAll();
    }

    @Override
    public Curso update(Long id, CursoUpdateForm form){
        Curso curso = findById(id);
        if(form.nome() != null && !form.nome().isBlank()){
            curso.setNome(form.nome());
        }
        if(form.valorMensalidade() != null){
            curso.setValorMensalidade(form.valorMensalidade());
        }
        return repository.save(curso);
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Curso não encontrado com id " + id);
        }
        repository.deleteById(id);
    }
}
