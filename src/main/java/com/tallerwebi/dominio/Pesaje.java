package com.tallerwebi.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pesaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fechaPesaje;
    private Double peso;

    public Pesaje() {
        //constructor por defecto
    }

    public Pesaje(String fechaPesaje, Double peso) {
        this.fechaPesaje = fechaPesaje;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaPesaje() {
        return fechaPesaje;
    }

    public void setFechaPesaje(String fechaPesaje) {
        this.fechaPesaje = fechaPesaje;
    }
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
