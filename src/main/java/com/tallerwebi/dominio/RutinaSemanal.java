package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class RutinaSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutinaSemanal", fetch = FetchType.EAGER)
    private List<RutinaDiaria> rutinasDiarias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<RutinaDiaria> getRutinasDiarias() {
        return rutinasDiarias;
    }

    public void setRutinasDiarias(List<RutinaDiaria> rutinasDiarias) {
        this.rutinasDiarias = rutinasDiarias;
    }
}