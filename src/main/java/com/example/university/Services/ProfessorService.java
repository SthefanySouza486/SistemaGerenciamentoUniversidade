package com.example.university.Services;

import com.example.university.DTOs.Professor.ProfessorCreateForm;
import com.example.university.DTOs.Professor.ProfessorUpdateForm;
import com.example.university.Entidades.Professor;

import java.util.List;

public interface ProfessorService {
    Professor create(ProfessorCreateForm form);
    Professor findById(Long id);
    List<Professor> findAll();
    Professor update(Long id, ProfessorUpdateForm form);
    void delete(Long id);
}
