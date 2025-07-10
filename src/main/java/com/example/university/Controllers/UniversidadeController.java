package com.example.university.Controllers;

import com.example.university.DTOs.Curso.CursoAtribuicaoForm;
import com.example.university.Services.UniversidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universidade")
public class UniversidadeController {

    private final UniversidadeService service;

    public UniversidadeController(UniversidadeService service) {
        this.service = service;
    }

    @PostMapping("/atribuir-curso")
    @ResponseStatus(HttpStatus.OK)
    public void assignProfessorToCourse (@RequestBody @Valid CursoAtribuicaoForm form) {
        service.assignProfessorToCourse(form.professorId(),  form.cursoId());
    }

    @DeleteMapping("/desatribuir-curso")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProfessorFromCourse (@RequestBody @Valid CursoAtribuicaoForm form) {
        service.removeProfessorFromCourse(form.professorId(),  form.cursoId());
    }
}
