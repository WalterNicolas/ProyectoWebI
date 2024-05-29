package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class RutinaDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RutinaSemanal rutinaSemanal;

    @ManyToMany
    private List<Ejercicio> ejercicios;


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

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }


}

