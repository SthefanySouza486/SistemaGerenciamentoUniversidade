package com.example.university.Controllers;

import com.example.university.DTOs.Escritorio.EscritorioCreateForm;
import com.example.university.DTOs.Escritorio.EscritorioUpdateForm;
import com.example.university.Entidades.Escritorio;
import com.example.university.Services.EscritorioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escritorio")
public class EscritorioController {

    private final EscritorioService service;

    public EscritorioController(EscritorioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Escritorio> create(@RequestBody @Valid EscritorioCreateForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<Escritorio>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escritorio> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escritorio> update(@PathVariable Long id, @RequestBody @Valid EscritorioUpdateForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
