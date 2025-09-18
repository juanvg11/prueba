// DiagnosticoDTO.java
package com.metaenlace.prueba.dto;

public class DiagnosticoDTO {
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
    private Long citaId; // referencia a la cita

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }
    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public Long getCitaId() {
        return citaId;
    }
    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }
}
