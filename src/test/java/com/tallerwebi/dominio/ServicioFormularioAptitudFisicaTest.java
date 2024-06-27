package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.tallerwebi.infraestructura.ServicioAptitudFisicaImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ServicioFormularioAptitudFisicaTest {
    ServicioAptitudFisica servicioAptitudFisica;
    RepositorioAptitudFisica repositorioAptitudFisica;


    RepositorioTipoEntrenamiento repositorioTipoEntrenamiento;

    @BeforeEach
    public void init(){
        // Mock del repositorio de tipo de entrenamiento
        repositorioTipoEntrenamiento = mock(RepositorioTipoEntrenamiento.class);

        // Inicialización del servicio con los mocks
        servicioAptitudFisica = new ServicioAptitudFisicaImp(repositorioAptitudFisica, repositorioTipoEntrenamiento);
    }

    private void givenNoHayDatos() {
    }
    private void thenRetornaAptitudFisica(AptitudFisica apto) {
        assertThat(apto,notNullValue());
        assertThat(apto.getAltura(),equalTo(185));
    }
    @Test
    public void siLaEdadEsMenorDe18LanceUnExcepcion(){
        givenNoHayDatos();
        whenLaEdadEsMenoa18();
    }

    private void whenLaEdadEsMenoa18() {
        AptitudFisica apto = new AptitudFisica();
        apto.setAltura(185);
        apto.setPeso(100.5);
        LocalDate fechaDeNacimiento = LocalDate.of(2018, 1, 31);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<TipoEntrenamiento> entrenamientosLis = new ArrayList<TipoEntrenamiento>();
        String[] arrayEntrenamiento = {"prueba"};
        TipoEntrenamiento entrenamiento = new TipoEntrenamiento("prueba", "Musculacion");
        when(repositorioTipoEntrenamiento.findByNombre("prueba")).thenReturn(entrenamiento);
        entrenamientosLis.add(entrenamiento);
        // Convertir la fecha de nacimiento a String
        String fechaDeNacimientoString = fechaDeNacimiento.format(formato);
        apto.setFechaNacimiento(fechaDeNacimientoString);
        apto.setTiposEntrenamiento(entrenamientosLis);
        apto.setHorasEntrenamiento(1);
        apto.setEstadoFisico("sedentario");
        assertThrows(esMenorDeEdadException.class,
                ()-> servicioAptitudFisica.registrarDatos(apto,arrayEntrenamiento));

    }
    @Test
    public void siFaltaAlgunDatoQueEnvieUnExcepcion(){
        givenNoHayDatos();
        whenFaltaAlgunDato();
    }

    private void whenFaltaAlgunDato() {
        AptitudFisica apto = new AptitudFisica();
        apto.setAltura(185);
        apto.setPeso(100.5);
        LocalDate fechaDeNacimiento = LocalDate.of(2018, 1, 31);

        // Crear un objeto DateTimeFormatter para el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] arrayEntrenamiento = {"prueba"};
        List<TipoEntrenamiento> entrenamientosLis = new ArrayList<TipoEntrenamiento>();
        TipoEntrenamiento entrenamiento = new TipoEntrenamiento();
        entrenamientosLis.add(entrenamiento);

        // Convertir la fecha de nacimiento a String
        String fechaDeNacimientoString = fechaDeNacimiento.format(formato);
        apto.setFechaNacimiento(fechaDeNacimientoString);
        apto.setTiposEntrenamiento(entrenamientosLis);
        apto.setEstadoFisico("sedentario");
        assertThrows(DatosMalIngresadosException.class,
                ()-> servicioAptitudFisica.registrarDatos(apto,arrayEntrenamiento));

    }
}
