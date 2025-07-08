package com.example.university.Impl;

import com.example.university.DTOs.Matricula.MatriculaCreateForm;
import com.example.university.DTOs.Matricula.MatriculaUpdateForm;
import com.example.university.Entidades.Curso;
import com.example.university.Entidades.Estudante;
import com.example.university.Entidades.IdMatricula;
import com.example.university.Entidades.Matricula;
import com.example.university.Repository.MatriculaRepository;
import com.example.university.Services.CursoService;
import com.example.university.Services.EstudanteService;
import com.example.university.Services.MatriculaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository repository;
    private final EstudanteService estudanteService;
    private final CursoService cursoService;

    public MatriculaServiceImpl(MatriculaRepository repository, EstudanteService estudanteService, CursoService cursoService) {
        this.repository = repository;
        this.estudanteService = estudanteService;
        this.cursoService = cursoService;
    }

    @Override
    public Matricula create (MatriculaCreateForm form){
        Estudante estudante = estudanteService.findById(form.estudanteId());
        Curso curso = cursoService.findById(form.cursoId());

        IdMatricula id = new IdMatricula(estudante.getId(), curso.getId());
        if(repository.existsById(id)){
            throw new IllegalArgumentException("Estudante ja matriculado neste curso");
        }

        Matricula matricula = new Matricula();
        matricula.setId(id);
        matricula.setCurso(curso);
        matricula.setEstudante(estudante);
        matricula.setDataMatricula(LocalDateTime.now());
        return repository.save(matricula);
    }

    @Override
    public Matricula findById(IdMatricula id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matricula não encontrada."));
    }

    @Override
    public List<Matricula> findAll(){
        return repository.findAll();
    }

    @Override
    public Matricula update (IdMatricula id, MatriculaUpdateForm form){
        Matricula matricula = findById(id);
        if(form.notas() != null){
            matricula.setNotas(form.notas());
        }
        return repository.save(matricula);
    }

    @Override
    public void delete (IdMatricula id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Matricula não encontrada.");
        }
        repository.deleteById(id);
    }
}
