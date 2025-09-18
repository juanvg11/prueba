package com.metaenlace.prueba.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medico extends Usuario {

    @Column(unique = true, nullable = false)
    private String numColegiado;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    public String getNumColegiado() {
        return numColegiado;
    }
    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }
    public List<Cita> getCitas() {
        return citas;
    }
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
