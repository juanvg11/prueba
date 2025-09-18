package com.metaenlace.prueba.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.metaenlace.prueba.model.Paciente;
import com.metaenlace.prueba.repository.PacienteRepository;

@Service
public class PacienteService {
    private final PacienteRepository repo;

    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    public List<Paciente> getAll() {
        return repo.findAll();
    }

    public Optional<Paciente> getById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado");
            
        }
        return repo.findById(id);
    }

    public Paciente save(Paciente p) {
        // Validación de usuario único
        if (repo.existsByUsuario(p.getUsuario())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        // Validación de NSS único
        if (repo.existsByNss(p.getNSS())) {
            throw new RuntimeException("El NSS ya existe");
        }

        return repo.save(p);
    }

    public Paciente update(Long id, Paciente p) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado al actualizar");
        }

        p.setId(id);
       return repo.save(p);
    }

  /*   public Paciente update(Long id, Paciente p) {
    return repo.findById(id)
            .map(existing -> {
                existing.setNombre(p.getNombre());
                existing.setApellidos(p.getApellidos());
                existing.setUsuario(p.getUsuario());
                existing.setClave(p.getClave());
                existing.setNSS(p.getNSS());
                existing.setNumTarjeta(p.getNumTarjeta());
                existing.setTelefono(p.getTelefono());
                existing.setDireccion(p.getDireccion());

                // ⚠️ IMPORTANTE: citas mejor gestionarlas aparte (PUT en CitaService)
                // pero si quieres también actualizar la lista entera, podrías hacerlo aquí:
                // existing.setCitas(p.getCitas());

                return repo.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado al actualizar"));
} */


    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado al eliminar");
        }
        repo.deleteById(id);
    }
}
