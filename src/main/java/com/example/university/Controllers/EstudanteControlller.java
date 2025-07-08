package com.example.university.Controllers;

import com.example.university.DTOs.Estudante.EstudanteCreateForm;
import com.example.university.DTOs.Estudante.EstudanteUpdateForm;
import com.example.university.Entidades.Estudante;
import com.example.university.Repository.EstudanteRepository;
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
    private final EstudanteRepository repository;

    public EstudanteControlller(EstudanteService service, EstudanteRepository repository) {
        this.service = service;
        this.repository = repository;
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

    @GetMapping("/search/by-nome")
    public ResponseEntity<Estudante> findByNome(@RequestParam String nome) {
        return repository.findByNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/first")
    public ResponseEntity<Estudante> findFirstByOrderByNomeAsc() {
        return repository.findFirstByOrderByNomeAsc()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/order-desc")
    public ResponseEntity<List<Estudante>> findFirstByOrderByNomeDesc() {
        return ResponseEntity.ok(repository.findByOrderByNomeDesc());
    }
}
