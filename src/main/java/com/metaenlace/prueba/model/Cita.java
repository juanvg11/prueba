package com.metaenlace.prueba.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private String motivoCita;

    private int attribute11; 

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnostico_id", referencedColumnName = "id")
    private Diagnostico diagnostico;

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
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
