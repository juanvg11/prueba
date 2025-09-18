// CrearDiagnosticoDTO.java
package com.metaenlace.prueba.dto;

public class CrearDiagnosticoDTO {
    private String valoracionEspecialista;
    private String enfermedad;
    private Long citaId;

    // Getters y Setters
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
