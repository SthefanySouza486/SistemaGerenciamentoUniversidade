package com.example.university.Services;

import com.example.university.DTOs.Escritorio.EscritorioCreateForm;
import com.example.university.DTOs.Escritorio.EscritorioUpdateForm;
import com.example.university.Entidades.Escritorio;

import java.util.List;

public interface EscritorioService {
    Escritorio create(EscritorioCreateForm form);
    Escritorio findById(Long id);
    List<Escritorio> findAll();
    Escritorio update(Long id, EscritorioUpdateForm form);
    void delete(Long id);

}
