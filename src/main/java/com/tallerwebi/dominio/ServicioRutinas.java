package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import com.tallerwebi.presentacion.DataModel.Ejercicio;

import java.util.List;

public interface ServicioRutinas {

    List<Ejercicio> cargarEjercicios(List<Ejercicio> listaEjercicios);
    Integer contarEjerciciosCumplidos(DetalleRutina detalleRutina);
    Double calcularDiferenciaDeKilos(Double pesoInicial, Double pesoActual);
    Integer contarEjerciciosporHacer(DetalleRutina detalleRutina);
    Double calcularIMC(Double peso,Double altura);
}
