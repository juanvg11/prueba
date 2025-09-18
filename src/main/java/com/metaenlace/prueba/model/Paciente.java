package com.metaenlace.prueba.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Paciente extends Usuario {

    @Column(unique = true)
    private String nss;
    private String numTarjeta;
    private String telefono;
    private String direccion;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    public String getNSS() {
        return nss;
    }
    public void setNSS(String nss) {
        this.nss = nss;
    }
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Cita> getCitas() {
        return citas;
    }
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
}
}
