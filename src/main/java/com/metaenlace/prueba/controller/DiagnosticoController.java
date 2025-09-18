package com.metaenlace.prueba.controller;

import com.metaenlace.prueba.dto.CrearDiagnosticoDTO;
import com.metaenlace.prueba.dto.DiagnosticoDTO;
import com.metaenlace.prueba.service.DiagnosticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping
    public ResponseEntity<DiagnosticoDTO> create(@RequestBody CrearDiagnosticoDTO dto) {
        return ResponseEntity.ok(diagnosticoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoDTO>> findAll() {
        return ResponseEntity.ok(diagnosticoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoDTO> findById(@PathVariable Long id) {
        return diagnosticoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoDTO> update(@PathVariable Long id, @RequestBody CrearDiagnosticoDTO dto) {
        return diagnosticoService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (diagnosticoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
