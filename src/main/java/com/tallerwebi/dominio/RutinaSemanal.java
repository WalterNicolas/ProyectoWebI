package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RutinaSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "rutinaSemanal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RutinaDiaria> rutinasDiarias = new ArrayList<>();
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