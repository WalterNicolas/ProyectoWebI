package com.tallerwebi.dominio;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DetalleRutina {
    private List<Ejercicio> listaEjercicios;
    @OneToMany
    private List<Pesaje> listaPesajes;
    Double pesoInicial;
    Double pesoActual;

    // Constructores

    public DetalleRutina() {
        this.listaEjercicios = new ArrayList<Ejercicio>();
        this.listaPesajes = new ArrayList<Pesaje>();
    }

    // Getters y Setters

    public List<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    public void setListaEjercicios(List<Ejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public void addEjercicio(Ejercicio ejercicio) {
        this.listaEjercicios.add(ejercicio);
    }

    public List<Pesaje> getListaPesajes() {
        return listaPesajes;
    }
    public void setListaPesajes(List<Pesaje> listaPesajes) {
        this.listaPesajes = listaPesajes;
    }

    public void addPesaje(Pesaje pesaje){
        this.listaPesajes.add(pesaje);
    }

    public void obtenerUltimoPeso(){
        Integer ultimo = this.listaPesajes.size()-1;
        this.pesoActual = this.listaPesajes.get(ultimo).getPeso();
    }

    public void obtenerPesoInicial(){
        this.pesoInicial = this.listaPesajes.get(0).getPeso();
    }
}
