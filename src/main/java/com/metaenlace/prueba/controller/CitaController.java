package com.metaenlace.prueba.controller;

import com.metaenlace.prueba.dto.CitaDTO;
import com.metaenlace.prueba.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    // =====================
    // 🔹 Obtener todas las citas
    // =====================
    @GetMapping
    public ResponseEntity<List<CitaDTO>> getAllCitas() {
        List<CitaDTO> citas = citaService.getAll();
        return ResponseEntity.ok(citas);
    }

    // =====================
    // 🔹 Obtener cita por ID
    // =====================
    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getCitaById(@PathVariable Long id) {
        Optional<CitaDTO> cita = citaService.getById(id);
        return cita.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // =====================
    // 🔹 Crear nueva cita
    // =====================
    @PostMapping
    public ResponseEntity<CitaDTO> createCita(@RequestBody CitaDTO dto) {
        CitaDTO nuevaCita = citaService.save(dto);
        return ResponseEntity.ok(nuevaCita);
    }

    // =====================
    // 🔹 Actualizar cita existente
    // =====================
    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> updateCita(@PathVariable Long id, @RequestBody CitaDTO dto) {
        try {
            CitaDTO updatedCita = citaService.update(id, dto);
            return ResponseEntity.ok(updatedCita);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // =====================
    // 🔹 Eliminar cita
    // =====================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        try {
            citaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
