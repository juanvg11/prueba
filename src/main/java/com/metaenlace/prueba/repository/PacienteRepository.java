package com.metaenlace.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metaenlace.prueba.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
     boolean existsByUsuario(String usuario);
     boolean existsByNss(String nss);
}
