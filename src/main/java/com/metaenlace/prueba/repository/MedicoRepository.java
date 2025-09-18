package com.metaenlace.prueba.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.metaenlace.prueba.model.Medico;


/* 
 * DECLARO unicamente metodos adicionales para consultas personalizadas.
 * Los metodos save, existsById, findById, findAll, deleteById, etc
 * ya los proporciona JpaRepository.
 */
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByNumColegiado(String numColegiado);
    
}
