package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class RutinaDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RutinaSemanal rutinaSemanal;


    @ManyToMany
    @JoinTable(
            name = "rutina_diaria_ejercicio",
            joinColumns = @JoinColumn(name = "rutina_diaria_id"),
            inverseJoinColumns = @JoinColumn(name = "ejercicio_id")
    )
    private Set<Ejercicio> ejercicios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RutinaSemanal getRutinaSemanal() {
        return rutinaSemanal;
    }

    public void setRutinaSemanal(RutinaSemanal rutinaSemanal) {
        this.rutinaSemanal = rutinaSemanal;
    }

    public Set<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Set<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }


}

