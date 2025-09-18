package com.metaenlace.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metaenlace.prueba.model.Cita;


public interface CitaRepository extends JpaRepository<Cita, Long> {
    

}
