package com.microservicios.estudiante.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class EstudianteEntity {

    @Id
    private int rut;
    private String nombreCompleto;
    private int edad;
    private String curso;

    // Getters y Setters
    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
