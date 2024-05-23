package com.tallerwebi.dominio;

public class Ejercicio {
    private String descripcionEjercicio;
    private Integer repeticiones;
    private Boolean realizado;

    // Constructores
    public Ejercicio() {
        //Constructor por defecto
    }
    public Ejercicio(String descripcionEjercicio, Integer repeticiones) {
        this.descripcionEjercicio = descripcionEjercicio;
        this.repeticiones = repeticiones;
        this.realizado = false;
    }

    // Getters y Setters

    public String getDescripcionEjercicio() {
        return descripcionEjercicio;
    }

    public void setDescripcionEjercicio(String descripcionEjercicio) {
        this.descripcionEjercicio = descripcionEjercicio;
    }

    public Integer getRepeticiones() {
        return this.repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Boolean getRealizado() {
        return this.realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public void completarEjercicio(){
        this.realizado = true;
    }
}
