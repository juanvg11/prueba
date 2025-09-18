package com.metaenlace.prueba.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.metaenlace.prueba.model.Medico;

import com.metaenlace.prueba.repository.MedicoRepository;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    

      public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
        
    }

    public List<Medico> getAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> getById(Long id) {
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Médico no encontrado");
        
        }
        return medicoRepository.findById(id);
    }

    public Medico save(Medico m) {
        if(medicoRepository.existsByNumColegiado(m.getNumColegiado())) {
            throw new RuntimeException("El número de colegiado ya existe");

        }
        return medicoRepository.save(m);
    }

    public Medico update(Long id, Medico m) {
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Médico no encontrado al actualizar");
        }

        m.setId(id);
        return medicoRepository.save(m);
    }

    public void delete(Long id) {
         if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Medico no encontrado al eliminar");
        }
      
       /*  if(repo.hasCitas(id)) {
            throw new RuntimeException("No se puede eliminar un médico con citas asignadas");

        } */
        System.out.println("Eliminando médico con ID: " + id);
         // Aquí podrías agregar lógica adicional si es necesario
         // Por ejemplo, verificar si el médico tiene pacientes asignados
         // y manejar esa lógica antes de eliminarlo.
         // repo.findById(id).ifPresent(medico -> {
         //     if (!medico.getPacientes().isEmpty()) {
         //         throw new RuntimeException("No se puede eliminar un médico con pacientes asignados");
         //     }
         // });


        medicoRepository.deleteById(id);
    }
}
