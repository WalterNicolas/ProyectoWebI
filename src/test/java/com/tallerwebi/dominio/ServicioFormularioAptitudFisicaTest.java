package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.tallerwebi.infraestructura.ServicioAptitudFisicaImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ServicioFormularioAptitudFisicaTest {
    ServicioAptitudFisica servicioAptitudFisica;
    RepositorioAptitudFisica repositorioAptitudFisica;
    /*
    1. si es menor de edad que no se pueda registrar
    2.todos los datos deben estar correctos
     */
    @BeforeEach
    public void init(){
        servicioAptitudFisica = new ServicioAptitudFisicaImp(repositorioAptitudFisica);
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
        // Crear un objeto DateTimeFormatter para el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convertir la fecha de nacimiento a String
        String fechaDeNacimientoString = fechaDeNacimiento.format(formato);
        apto.setFechaNacimiento(fechaDeNacimientoString);
        apto.setTipoEntrenamiento("Gym");
        apto.setDiasEntrenamiento(3);
        apto.setHorasEntrenamiento(1);
        apto.setEstadoFisico("sedentario");
        assertThrows(esMenorDeEdadException.class,
                ()-> servicioAptitudFisica.registrarDatos(apto));

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

        // Convertir la fecha de nacimiento a String
        String fechaDeNacimientoString = fechaDeNacimiento.format(formato);
        apto.setFechaNacimiento(fechaDeNacimientoString);
        apto.setTipoEntrenamiento("Gym");
        apto.setDiasEntrenamiento(3);
        apto.setEstadoFisico("sedentario");
        assertThrows(DatosMalIngresadosException.class,
                ()-> servicioAptitudFisica.registrarDatos(apto));

    }
}
