package com.metaenlace.prueba.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.metaenlace.prueba.model.Diagnostico;
import com.metaenlace.prueba.repository.DiagnosticoRepository;

@Service
public class DiagnosticoService {
    private final DiagnosticoRepository repo;

    public DiagnosticoService(DiagnosticoRepository repo) {
        this.repo = repo;
    }

    public List<Diagnostico> getAll() {
        return repo.findAll();
    }

    public Optional<Diagnostico> getById(Long id) {
        return repo.findById(id);
    }

    public Diagnostico save(Diagnostico d) {
        return repo.save(d);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
