package com.metaenlace.prueba.controller;

import com.metaenlace.prueba.model.Diagnostico;
import com.metaenlace.prueba.service.DiagnosticoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService service;

    public DiagnosticoController(DiagnosticoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Diagnostico> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Diagnostico getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    @PostMapping
    public Diagnostico save(@RequestBody Diagnostico diagnostico) {
        return service.save(diagnostico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
