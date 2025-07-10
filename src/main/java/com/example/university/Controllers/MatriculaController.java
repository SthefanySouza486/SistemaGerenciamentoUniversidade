package com.example.university.Controllers;

import com.example.university.DTOs.Matricula.MatriculaCreateForm;
import com.example.university.DTOs.Matricula.MatriculaUpdateForm;
import com.example.university.Entidades.IdMatricula;
import com.example.university.Entidades.Matricula;
import com.example.university.Repository.MatriculaRepository;
import com.example.university.Services.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;
    private final MatriculaRepository repository;

    public  MatriculaController(MatriculaService service, MatriculaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Matricula> create(@RequestBody @Valid MatriculaCreateForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{estudanteId}/{cursoId}")
    public ResponseEntity<Matricula> findById(@PathVariable Long estudanteId, @PathVariable Long cursoId) {
        IdMatricula id = new IdMatricula(estudanteId, cursoId);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{estudanteId}/{cursoId}")
    public ResponseEntity<Matricula> update(@PathVariable Long estudanteId, @PathVariable Long cursoId,
                                            @RequestBody @Valid MatriculaUpdateForm form) {
        IdMatricula id = new IdMatricula(estudanteId, cursoId);
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{estudanteId}/{cursoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long estudanteId, @PathVariable Long cursoId) {
        IdMatricula id = new IdMatricula(estudanteId, cursoId);
        service.delete(id);
    }

    @GetMapping("/by-estudante/{estudanteId}")
    public ResponseEntity<List<Matricula>> findByEstudanteId(@PathVariable Long estudanteId) {
        return ResponseEntity.ok(repository.findByEstudanteId(estudanteId));
    }

    @GetMapping("/by-curso/{cursoId}")
    public ResponseEntity<List<Matricula>> findByCursoId(@PathVariable Long cursoId) {
        return ResponseEntity.ok(repository.findByCursoId(cursoId));
    }

    @GetMapping("/search/data-depois")
    public ResponseEntity<List<Matricula>> findByMatriculaDateAfter(@RequestParam @DateTimeFormat(iso =
            DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {
        return ResponseEntity.ok(repository.findByMatriculaDateAfter(data));
    }
}
