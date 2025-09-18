package com.metaenlace.prueba.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.metaenlace.prueba.model.Cita;
import com.metaenlace.prueba.model.Paciente;
import com.metaenlace.prueba.model.Medico;
import com.metaenlace.prueba.model.Diagnostico;
import com.metaenlace.prueba.repository.CitaRepository;
import com.metaenlace.prueba.dto.CitaDTO;

@Service
public class CitaService {
    private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    // =====================
    // 🔹 Métodos de mapeo
    // =====================
    private CitaDTO toDTO(Cita cita) {
        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setFechaHora(cita.getFechaHora());
        dto.setMotivoCita(cita.getMotivoCita());
        dto.setAttribute11(cita.getAttribute11());

        if (cita.getPaciente() != null) {
            dto.setPacienteId(cita.getPaciente().getId());
        }
        if (cita.getMedico() != null) {
            dto.setMedicoId(cita.getMedico().getId());
        }
        if (cita.getDiagnostico() != null) {
            dto.setDiagnosticoId(cita.getDiagnostico().getId());
        }

        return dto;
    }

    private Cita toEntity(CitaDTO dto) {
        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setFechaHora(dto.getFechaHora());
        cita.setMotivoCita(dto.getMotivoCita());
        cita.setAttribute11(dto.getAttribute11());

        if (dto.getPacienteId() != null) {
            Paciente paciente = new Paciente();
            paciente.setId(dto.getPacienteId());
            cita.setPaciente(paciente);
        }
        if (dto.getMedicoId() != null) {
            Medico medico = new Medico();
            medico.setId(dto.getMedicoId());
            cita.setMedico(medico);
        }
        if (dto.getDiagnosticoId() != null) {
            Diagnostico diagnostico = new Diagnostico();
            diagnostico.setId(dto.getDiagnosticoId());
            cita.setDiagnostico(diagnostico);
        }

        return cita;
    }

    // =====================
    // 🔹 CRUD con DTOs
    // =====================
    public List<CitaDTO> getAll() {
        return repo.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CitaDTO> getById(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    public CitaDTO save(CitaDTO dto) {
        Cita cita = toEntity(dto);
        return toDTO(repo.save(cita));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Cita no encontrada para eliminar");
        }
        repo.deleteById(id);
    }

    public CitaDTO update(Long id, CitaDTO dto) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Cita no encontrada al actualizar");
        }
        dto.setId(id);
        Cita cita = toEntity(dto);
        return toDTO(repo.save(cita));
    }
}
