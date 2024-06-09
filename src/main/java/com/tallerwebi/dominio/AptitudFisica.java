package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AptitudFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int altura;
    private double peso;
    private String fechaNacimiento;
    private int diasEntrenamiento;
    private int horasEntrenamiento;
    private String estadoFisico;
    @OneToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "AptitudFisicaTipoEntrenamiento",
            joinColumns = @JoinColumn(name = "aptitudFisica_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoEntrenamiento_id")

    )
    private Set<TipoEntrenamiento> tiposEntrenamiento = new HashSet<>();


    // Constructor vacío
    public AptitudFisica() {
    }

    // Getters y setters para cada campo
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<TipoEntrenamiento> getTipoEntrenamiento() {
        return tiposEntrenamiento;
    }

    public void setTipoEntrenamiento(Set<TipoEntrenamiento> tipoEntrenamiento) {
        this.tiposEntrenamiento = tipoEntrenamiento;
    }

    public int getDiasEntrenamiento() {
        return diasEntrenamiento;
    }

    public void setDiasEntrenamiento(int diasEntrenamiento) {
        this.diasEntrenamiento = diasEntrenamiento;
    }

    public int getHorasEntrenamiento() {
        return horasEntrenamiento;
    }

    public void setHorasEntrenamiento(int horasEntrenamiento) {
        this.horasEntrenamiento = horasEntrenamiento;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }
}