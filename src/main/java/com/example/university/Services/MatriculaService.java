package com.example.university.Services;

import com.example.university.DTOs.Matricula.MatriculaCreateForm;
import com.example.university.DTOs.Matricula.MatriculaUpdateForm;
import com.example.university.Entidades.IdMatricula;
import com.example.university.Entidades.Matricula;

import java.util.List;

public interface MatriculaService {
    Matricula create(MatriculaCreateForm form);
    Matricula findById(IdMatricula id);
    List<Matricula> findAll();
    Matricula update(IdMatricula id, MatriculaUpdateForm form);
    void delete(IdMatricula id);
}
