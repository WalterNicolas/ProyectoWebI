package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TipoEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Set<AptitudFisica> getAptitudesFisicas() {
        return aptitudesFisicas;
    }

    public void setAptitudesFisicas(Set<AptitudFisica> aptitudesFisicas) {
        this.aptitudesFisicas = aptitudesFisicas;
    }

    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "tiposEntrenamiento")
    private Set<AptitudFisica> aptitudesFisicas;

    public TipoEntrenamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoEntrenamiento(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoEntrenamiento (){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
