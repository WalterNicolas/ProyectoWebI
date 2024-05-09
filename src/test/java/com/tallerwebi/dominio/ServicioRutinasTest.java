package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import com.tallerwebi.presentacion.DataModel.Ejercicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioRutinasTest {
    ServicioRoutines servicioRoutines;
    /*
    1. que se pueda crear una lista de ejercicios
    2. que se pueda marcar un ejercicio como realizado
    3. que se pueda calcular el IMC
    4. que se pueda calcular la diferencia de peso
     */
    @BeforeEach
    public void init(){
        servicioRoutines = new ServicioRoutinesImp();

    }

    @Test
    public void queSePuedaCrearUnaListaDeEjercicios(){
        givenNoExisteListaDeEjercicios();
        List<Ejercicio> listaEjercicios =  whenIngresarListaDeEjercicios();
        thenRetornaListaDeEjercicios(listaEjercicios);
    }

    private void givenNoExisteListaDeEjercicios() {
    }


    private List<Ejercicio> whenIngresarListaDeEjercicios() {
        DetalleRutina detalleRutina = new DetalleRutina ();
        Ejercicio unEjercicio = new Ejercicio ("abdominales",30);
        Ejercicio otroEjercicio = new Ejercicio ("flexiones de brazos",45);
        Ejercicio algunEjercicio = new Ejercicio ("sentadillas",20);
        detalleRutina.addEjercicio(unEjercicio);
        detalleRutina.addEjercicio(otroEjercicio);
        detalleRutina.addEjercicio(algunEjercicio);
        return servicioRoutines.cargarEjercicios(detalleRutina.getListaEjercicios());
    }

    private void thenRetornaListaDeEjercicios(List<Ejercicio> listaEjercicios) {
        assertThat(listaEjercicios,notNullValue());
    }

    @Test
    public void queSePuedaMarcarUnEjercicioComoRealizado(){
        List<Ejercicio> listaEjercicios = givenExisteListaDeEjercicios();
        Ejercicio unEjercicio = new Ejercicio ("flexiones de brazos",45);
        whenRealizarUnEjercicioDeLaLista(listaEjercicios,unEjercicio);
        thenRetornaListaDeEjercicios(listaEjercicios);
    }

    private List<Ejercicio> whenRealizarUnEjercicioDeLaLista(List<Ejercicio> listaEjercicios, Ejercicio unEjercicio){
        Ejercicio actual = new Ejercicio();
        for(actual : listaEjercicios){
            if(actual.getDescripcionEjercicio().equals(unEjercicio.getDescripcionEjercicio())) {
                actual.completarEjercicio();
            }
        return listaEjercicios;
        }
    }

    private List<Ejercicio> givenExisteListaDeEjercicios() {
        List<Ejercicio> listaEjercicios =  whenIngresarListaDeEjercicios();
        return listaEjercicios;
    }

    @Test
    public void queSePuedaCalcularElIMC(){
        givenExistenDatos();
        Double imc = whenCalculaIMC(75.5,1.65);
        thenRetornaIMC(imc);
    }

    @Test
    public void queSePuedaCalcularLaDiferenciaDePeso(){
        givenExistenDatos();
        Double difPeso = whenCalculaDiferenciaDePeso(88.2,75.5);
        thenRetornaDiferenciaDePeso(difPeso);
    }

    private void givenExistenDatos() {
    }

    private Double whenCalculaIMC(peso,altura) {
        return servicioRoutines.calcularIMC(peso,altura);
    }

    private void whenCalculaDiferenciaDePeso(pesoInicial,pesoActual) {
        return servicioRoutines.calcularDiferenciaDeKilos(pesoinicial,pesoActual);
    }

    private void thenRetornaIMC() {
        assertThat(imc,notNullValue());
    }

    private void thenRetornaDiferenciaDePeso() {
        assertThat(difPeso,notNullValue());
    }
}
