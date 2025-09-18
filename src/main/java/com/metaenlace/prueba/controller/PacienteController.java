package com.metaenlace.prueba.controller;

import com.metaenlace.prueba.model.Paciente;
import com.metaenlace.prueba.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Paciente getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    //Ejemplo de JSON para el body: 
    /* 
{
  "nombre": "ANTONIO",
  "apellidos": "FEAFWE",
  "usuario": "strWEAFWAing",
  "clave": "strFRGRGRing",
  "nss": "stGREGERring",
  "numTarjeta": "stGERGERring",
  "telefono": "strGERGERing",
  "direccion": "striGERGREng",
  "citas": []
}
 */
    @PostMapping
    public Paciente save(@RequestBody Paciente paciente) {
        return service.save(paciente);
    }

    //Solo actuliza el paciente, sin las citas
    //Ejemplo de JSON para el body: 
    /* {
        {
  "id": 13,
  "nombre": "pRUEBA ACTU",
  "apellidos": "García",
  "usuario": "avg7",
  "clave": "121212",
  "nss": "00000000",
  "numTarjeta": "9999999",
  "telefono": "712 123 832",
  "direccion": "Calle PRUEBAS",
  "citas": [
 
    
  ]
}
    } */
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        service.update(id, paciente);
    }
    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
