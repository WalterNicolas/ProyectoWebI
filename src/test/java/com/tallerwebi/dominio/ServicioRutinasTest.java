package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.NoHayEjerciciosCargadosException;
import com.tallerwebi.infraestructura.ServicioRutinaImp;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioRutinasTest {
    ServicioRutina servicioRutina;

    /*
    1. que se pueda crear una lista de ejercicios
    2. que se pueda marcar un ejercicio como realizado
    3. que se pueda calcular el IMC
    4. que se pueda calcular la diferencia de peso
    5. que se puedan contar los ejercicios realizados
    6. que se puedan contar los ejercicios por hacer
         */
    @BeforeEach
    public void init() {
        servicioRutina = new ServicioRutinaImp();

    }

    @Test
    public void queSePuedaCrearUnaListaDeEjercicios() {
        givenNoExisteListaDeEjercicios();
        List<Ejercicio> listaEjercicios = whenIngresarListaDeEjercicios();
        thenRetornaListaDeEjercicios(listaEjercicios);
    }

    @Test
    public void queSePuedaMarcarUnEjercicioComoRealizado() {
        List<Ejercicio> listaEjercicios = givenExisteListaDeEjercicios();
        Ejercicio unEjercicio = new Ejercicio();
        whenRealizarUnEjercicioDeLaLista(listaEjercicios, unEjercicio);
        thenRetornaListaDeEjercicios(listaEjercicios);
    }

    @Test
    public void queSePuedaCalcularElIMC() {
        givenExistenDatos();
        Double pesoActual = 75.5;
        Double altura = 1.65;
        Double imc = whenCalculaIMC();
        thenRetornaIMC(imc);
    }

    @Test
    public void queSePuedaCalcularLaDiferenciaDePeso() {
        givenExistenDatos();
        Double difPeso = whenCalculaDiferenciaDePeso();
        thenRetornaDiferenciaDePeso(difPeso);
    }

    @Test
    public void queSePuedanContarLosEjericiosRealizados() throws NoHayEjerciciosCargadosException {
//        List<Ejercicio> listaEjercicios = givenExisteListaDeEjercicios();
//        Ejercicio unEjercicio = new Ejercicio("flexiones de brazos", 45);
//        whenRealizarUnEjercicioDeLaLista(listaEjercicios, unEjercicio);
//        DetalleRutina detalleRutina = new DetalleRutina();
//        detalleRutina.setListaEjercicios(listaEjercicios);
//        thenRetornaCantidadDeEjerciciosRealizados(detalleRutina);
    }

    @Test
    public void queSePuedanContarLosEjericiosPorHacer() throws NoHayEjerciciosCargadosException {
//        List<Ejercicio> listaEjercicios = givenExisteListaDeEjercicios();
//        Ejercicio algunEjercicio = new Ejercicio("sentadillas", 20);
//        whenRealizarUnEjercicioDeLaLista(listaEjercicios, algunEjercicio);
//        DetalleRutina detalleRutina = new DetalleRutina();
//        detalleRutina.setListaEjercicios(listaEjercicios);
//        thenRetornaCantidadDeEjerciciosPorHacer(detalleRutina);
    }

    private List<Ejercicio> whenRealizarUnEjercicioDeLaLista(@NotNull List<Ejercicio> listaEjercicios, Ejercicio unEjercicio) {
//        Ejercicio actual = new Ejercicio();
        for (Ejercicio actual : listaEjercicios) {
            if (actual.getDescripcion().equals(unEjercicio.getDescripcion())) {
                actual.setRealizado(Boolean.TRUE);
            }
            return listaEjercicios;
        }
        return listaEjercicios;
    }

    private List<Ejercicio> givenExisteListaDeEjercicios() {
        List<Ejercicio> listaEjercicios = whenIngresarListaDeEjercicios();
        return listaEjercicios;
    }

    private void givenExistenDatos() {
    }

    private Double whenCalculaIMC() {
        Double pesoActual = 75.5;
        Double altura = 1.65;
        return servicioRutina.calcularIMC(pesoActual, altura);
    }

    private Double whenCalculaDiferenciaDePeso() {
        Double pesoInicial = 88.2;
        Double pesoActual = 75.5;
        return servicioRutina.calcularDiferenciaDeKilos(pesoInicial, pesoActual);
    }

    private void thenRetornaIMC(Double imc) {
        assertThat(imc, notNullValue());
    }

    private void thenRetornaDiferenciaDePeso(Double difPeso) {
        assertThat(difPeso, notNullValue());
    }

    private void thenRetornaCantidadDeEjerciciosPorHacer(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        assertEquals(servicioRutina.contarEjerciciosporHacer(detalleRutina),2);
    }

    private void thenRetornaCantidadDeEjerciciosRealizados(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        assertEquals(servicioRutina.contarEjerciciosCumplidos(detalleRutina),1);
    }

    private void givenNoExisteListaDeEjercicios() {
    }


    private List<Ejercicio> whenIngresarListaDeEjercicios() {
        Ejercicio unEjercicio = new Ejercicio();
        unEjercicio.setDescripcion("3 reps 4 series");
        Ejercicio otroEjercicio = new Ejercicio();
        otroEjercicio.setDescripcion("3 reps 4 series");
        Ejercicio algunEjercicio = new Ejercicio();
        algunEjercicio.setDescripcion("3 reps 4 series");
        DetalleRutina detalleRutina = new DetalleRutina();
        detalleRutina.addEjercicio(unEjercicio);
        detalleRutina.addEjercicio(otroEjercicio);
        detalleRutina.addEjercicio(algunEjercicio);
        return servicioRutina.cargarEjercicios(detalleRutina.getListaEjercicios());
    }

    private void thenRetornaListaDeEjercicios(List<Ejercicio> listaEjercicios) {
        assertThat(listaEjercicios, notNullValue());
    }
}

