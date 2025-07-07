package com.example.university.Services;

import com.example.university.DTOs.Curso.CursoCreateForm;
import com.example.university.DTOs.Curso.CursoUpdateForm;
import com.example.university.Entidades.Curso;

import java.util.List;

public interface CursoService {
    Curso create(CursoCreateForm form);
    Curso findById(Long id);
    List<Curso> findAll();
    Curso update(Long id, CursoUpdateForm form);
    void delete(Long id);
}
