package com.example.university.Controllers;

import com.example.university.DTOs.Professor.ProfessorCreateForm;
import com.example.university.DTOs.Professor.ProfessorUpdateForm;
import com.example.university.Entidades.Professor;
import com.example.university.Repository.ProfessorRepository;
import com.example.university.Services.ProfessorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;
    private final ProfessorRepository repository;

    public ProfessorController(ProfessorService service, ProfessorRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody ProfessorCreateForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody ProfessorUpdateForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search/by-email")
    public ResponseEntity<Professor> findByEmail(@RequestParam String email) {
        return repository.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/by-name-and-email")
    public ResponseEntity<Professor> findByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return repository.findByNameAndEmail(name, email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/by-nome-or-email")
    public ResponseEntity<List<Professor>> findByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(repository.findByNameOrEmail(name, email));
    }

    @GetMapping("/search/by-dataContrato-between")
    public ResponseEntity<List<Professor>> findByDataContratoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate comeco,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return ResponseEntity.ok(repository.findByDataContratacaoBetween(comeco, fim));
    }

    @GetMapping("/search/by-nome-ordenado")
    public ResponseEntity<List<Professor>> findByNameOrderByDataContratacaoDesc (@RequestParam String nome) {
        return ResponseEntity.ok(repository.findByNameOrderByDataContratacaoDesc(nome));
    }

    @DeleteMapping("/by-email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEmail(@RequestParam String email) {
        repository.deleteByEmail(email);
    }
}
