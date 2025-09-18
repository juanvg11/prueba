package com.metaenlace.prueba.service;

import com.metaenlace.prueba.dto.CrearDiagnosticoDTO;
import com.metaenlace.prueba.dto.DiagnosticoDTO;
import com.metaenlace.prueba.model.Cita;
import com.metaenlace.prueba.model.Diagnostico;
import com.metaenlace.prueba.repository.CitaRepository;
import com.metaenlace.prueba.repository.DiagnosticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepo;
    private final CitaRepository citaRepo;

    public DiagnosticoService(DiagnosticoRepository diagnosticoRepo, CitaRepository citaRepo) {
        this.diagnosticoRepo = diagnosticoRepo;
        this.citaRepo = citaRepo;
    }

    // Convertir Entity → DTO
    private DiagnosticoDTO toDTO(Diagnostico diagnostico) {
        DiagnosticoDTO dto = new DiagnosticoDTO();
        dto.setId(diagnostico.getId());
        dto.setValoracionEspecialista(diagnostico.getValoracionEspecialista());
        dto.setEnfermedad(diagnostico.getEnfermedad());
        if (diagnostico.getCita() != null) {
            dto.setCitaId(diagnostico.getCita().getId());
        }
        return dto;
    }

    // Crear nuevo diagnóstico
    public DiagnosticoDTO create(CrearDiagnosticoDTO dto) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setValoracionEspecialista(dto.getValoracionEspecialista());
        diagnostico.setEnfermedad(dto.getEnfermedad());

        if (dto.getCitaId() != null) {
            Optional<Cita> cita = citaRepo.findById(dto.getCitaId());
            cita.ifPresent(diagnostico::setCita);
        }

        return toDTO(diagnosticoRepo.save(diagnostico));
    }

    // Obtener todos
    public List<DiagnosticoDTO> findAll() {
        return diagnosticoRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener por id
    public Optional<DiagnosticoDTO> findById(Long id) {
        return diagnosticoRepo.findById(id)
                .map(this::toDTO);
    }

    // Actualizar
    public Optional<DiagnosticoDTO> update(Long id, CrearDiagnosticoDTO dto) {
        return diagnosticoRepo.findById(id).map(diagnostico -> {
            diagnostico.setValoracionEspecialista(dto.getValoracionEspecialista());
            diagnostico.setEnfermedad(dto.getEnfermedad());

            if (dto.getCitaId() != null) {
                citaRepo.findById(dto.getCitaId()).ifPresent(diagnostico::setCita);
            }

            return toDTO(diagnosticoRepo.save(diagnostico));
        });
    }

    // Eliminar
    public boolean delete(Long id) {
        if (diagnosticoRepo.existsById(id)) {
            diagnosticoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
