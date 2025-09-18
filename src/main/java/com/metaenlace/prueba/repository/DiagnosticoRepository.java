package com.metaenlace.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metaenlace.prueba.model.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
