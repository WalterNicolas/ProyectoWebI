package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.NoHayEjerciciosCargadosException;

import java.util.List;
import java.util.Set;

public interface ServicioRutina {

    List<Ejercicio> cargarEjercicios(List<Ejercicio> listaEjercicios);
    Integer contarEjerciciosCumplidos(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException;
    Double calcularDiferenciaDeKilos(Double pesoInicial, Double pesoActual);
    Integer contarEjerciciosporHacer(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException;
    Double calcularIMC(Double peso,Double altura);
    RutinaSemanal generarRutinaSemanal(Usuario usuario);
    Set<Ejercicio> generarEjerciciosDia(int horasPorSesion, String tipoEntrenamiento);

}
