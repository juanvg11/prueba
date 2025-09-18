package com.metaenlace.prueba.dto;

import java.util.Date;

//El DTO es un objeto simple para transferir datos al cliente, evitando enviar toda la entidad con relaciones completas.

public class CitaDTO {
    private Long id;
    private Date fechaHora;
    private String motivoCita;
    private int attribute11;

    private Long pacienteId; // Solo el ID, no todo el objeto
    private Long medicoId;
    private Long diagnosticoId;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String getMotivoCita() {
        return motivoCita;
    }
    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }
    public int getAttribute11() {
        return attribute11;
    }
    public void setAttribute11(int attribute11) {
        this.attribute11 = attribute11;
    }
    public Long getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    public Long getMedicoId() {
        return medicoId;
    }
    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }
    public Long getDiagnosticoId() {
        return diagnosticoId;
    }
    public void setDiagnosticoId(Long diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }
}
