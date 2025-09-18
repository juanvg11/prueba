package com.metaenlace.prueba.controller;

import com.metaenlace.prueba.model.Medico;
import com.metaenlace.prueba.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medico> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Medico getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    /* 
     * Ejemplo de JSON para el body:
        {
        "nombre": "Juan",
        "apellidos": "Velasco",
        "usuario": "juanvg11",
        "clave": "clave123",
        "numColegiado": "123456",
        "citas": [
        ]
        }
     */
    @PostMapping
    public Medico save(@RequestBody Medico medico) {
        return service.save(medico);
    }

    @PutMapping("/{id}")
    public Medico update(@PathVariable Long id, @RequestBody Medico medico) {
        medico.setId(id);
        return service.update(id, medico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
