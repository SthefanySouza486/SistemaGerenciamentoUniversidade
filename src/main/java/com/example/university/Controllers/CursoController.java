package com.example.university.Controllers;

import com.example.university.DTOs.Curso.CursoCreateForm;
import com.example.university.DTOs.Curso.CursoUpdateForm;
import com.example.university.Entidades.Curso;
import com.example.university.Repository.CursoRepository;
import com.example.university.Services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository repository;
    private final CursoService service;

    public CursoController(CursoRepository repository, CursoService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody @Valid CursoCreateForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso>  update(@PathVariable Long id, @RequestBody @Valid CursoUpdateForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search/by-ids")
    public ResponseEntity<List<Curso>> findByIdIn (@RequestParam List<Long> ids) {
        return ResponseEntity.ok(repository.findByIdIn(ids));
    }

    @GetMapping("/search/by-valorMensalidade-greater-than")
    public ResponseEntity<List<Curso>>  findByValorMensalidadeGreaterThan(@RequestParam BigDecimal valorMensalidade) {
        return ResponseEntity.ok(repository.findByValorMensalidadeGreaterThan(valorMensalidade));
    }

    @GetMapping("/search/by-valorMensalidade-greater-than-equal")
    public ResponseEntity<List<Curso>> findByValorMensalidadeGreaterThanEqual(@RequestParam BigDecimal valorMensalidade) {
        return ResponseEntity.ok(repository.findByValorMensalidadeGreaterThanEqual(valorMensalidade));
    }

    @GetMapping("/search/by-valorMensalidade-less-than")
    public ResponseEntity<List<Curso>>  findByValorMensalidadeLessThan(@RequestParam BigDecimal valorMensalidade) {
        return ResponseEntity.ok(repository.findByValorMensalidadeLessThan(valorMensalidade));
    }

    @GetMapping("/search/by-valorMensalidade-less-than-equal")
    public ResponseEntity<List<Curso>> findByValorMensalidadeLessThanEqual(@RequestParam BigDecimal valorMensalidade) {
        return ResponseEntity.ok(repository.findByValorMensalidadeLessThanEqual(valorMensalidade));
    }


}
