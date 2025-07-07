package com.example.university.Services;

import com.example.university.DTOs.Estudante.EstudanteCreateForm;
import com.example.university.DTOs.Estudante.EstudanteUpdateForm;
import com.example.university.Entidades.Estudante;

import java.util.List;

public interface EstudanteService {
    Estudante create(EstudanteCreateForm form);
    Estudante findById(Long id);
    List<Estudante> findAll();
    Estudante update(Long id, EstudanteUpdateForm form);
    void delete(Long id);
    List<String> getAllEstudanteNomesUpperCase();
}
