package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class RutinaSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "rutinaSemanal", cascade = CascadeType.ALL)
    private Set<RutinaDiaria> rutinaDiaria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Set<RutinaDiaria> getRutinaDiaria() {
        return rutinaDiaria;
    }

    public void setRutinaDiaria(Set<RutinaDiaria> rutinaDiaria) {
        this.rutinaDiaria = rutinaDiaria;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}