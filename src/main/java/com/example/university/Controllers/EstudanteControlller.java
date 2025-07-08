package com.example.university.Controllers;

import com.example.university.DTOs.Estudante.EstudanteCreateForm;
import com.example.university.DTOs.Estudante.EstudanteUpdateForm;
import com.example.university.Entidades.Estudante;
import com.example.university.Services.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteControlller {
    private final EstudanteService service;

    public EstudanteControlller(EstudanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Estudante> create(@RequestBody @Valid EstudanteCreateForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<Estudante>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> update(@PathVariable Long id, @RequestBody @Valid EstudanteUpdateForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/nomes/uppercase")
    public ResponseEntity<List<String>> getAllEstudanteNomesUpperCase() {
        return ResponseEntity.ok(service.getAllEstudanteNomesUpperCase());
    }
}
