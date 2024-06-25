package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.NoHayEjerciciosCargadosException;
import com.tallerwebi.infraestructura.ServicioRutinaImp;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class ServicioRutinasTest {
    ServicioRutina servicioRutina;
    RepositorioEjercicio repositorioEjercicioMock;
    RepositorioRutinaSemanal repositorioRutinaSemanalMock;
    RutinaSemanal rutinalSemanal;
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

        repositorioEjercicioMock = mock(RepositorioEjercicio.class);
        repositorioRutinaSemanalMock = mock(RepositorioRutinaSemanal.class);
        servicioRutina = new ServicioRutinaImp(repositorioEjercicioMock,repositorioRutinaSemanalMock);
        rutinalSemanal = mock(RutinaSemanal.class);
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

    @Test
    public void queSePuedaGenerarRutinaSemanal() {
        Usuario usuario = new Usuario();

        List<TipoEntrenamiento> entrenamientosLis = new ArrayList<TipoEntrenamiento>();
        TipoEntrenamiento entrenamiento = new TipoEntrenamiento("prueba", "Musculacion");
        entrenamientosLis.add(entrenamiento);

        AptitudFisica aptitudFisica = new AptitudFisica();
        aptitudFisica.setDiasEntrenamiento(3);
        aptitudFisica.setHorasEntrenamiento(1);
        aptitudFisica.setTiposEntrenamiento(entrenamientosLis);
        usuario.setAptitudFisica(aptitudFisica);

        List<Ejercicio> listEjercicios = new ArrayList<>(listaEjercicios());

        when(repositorioEjercicioMock.buscarTodosLosEjercicio()).thenReturn(listEjercicios);
        doNothing().when(repositorioRutinaSemanalMock).guardar(any(RutinaSemanal.class));

        List<RutinaSemanal> rutinaSemanal = servicioRutina.generarRutinaSemanal(usuario);


        assertNotNull(rutinaSemanal);
        assertEquals(1, rutinaSemanal.size());

        verify(repositorioRutinaSemanalMock, times(1)).guardar(any());
    }
    @Test
    public void queSePuedaGenerarDosRutinasSemanales() {
        Usuario usuario = new Usuario();

        List<TipoEntrenamiento> entrenamientosLista = new ArrayList<TipoEntrenamiento>();
        TipoEntrenamiento entrenamientoUno = new TipoEntrenamiento("prueba", "Musculacion");
        TipoEntrenamiento entrenamientoDos = new TipoEntrenamiento("prueba", "Cardio");
        entrenamientosLista.add(entrenamientoUno);
        entrenamientosLista.add(entrenamientoDos);
        AptitudFisica aptitudFisica = new AptitudFisica();
        aptitudFisica.setDiasEntrenamiento(3);
        aptitudFisica.setHorasEntrenamiento(1);
        aptitudFisica.setTiposEntrenamiento(entrenamientosLista);
        usuario.setAptitudFisica(aptitudFisica);

        List<Ejercicio> listEjercicios = new ArrayList<>(listaEjercicios());

        when(repositorioEjercicioMock.buscarTodosLosEjercicio()).thenReturn(listEjercicios);
        doNothing().when(repositorioRutinaSemanalMock).guardar(any(RutinaSemanal.class));

        List<RutinaSemanal> rutinaSemanal = servicioRutina.generarRutinaSemanal(usuario);


        assertNotNull(rutinaSemanal);
        assertEquals(2, rutinaSemanal.size());

        verify(repositorioRutinaSemanalMock, times(2)).guardar(any());
    }

    @Test
    public void testGenerarEjerciciosDia() {
        // Arrange
        int horasPorSesion = 1;
        String tipoEntrenamiento = "Cardio";
        Set<Ejercicio> ejerciciosDisponibles = listaEjercicios();

        when(repositorioEjercicioMock.buscarTodosLosEjercicio()).thenReturn(new ArrayList<>(ejerciciosDisponibles)); // Convertir Set a List

        // Act
        List<Ejercicio> ejerciciosDia = servicioRutina.generarEjerciciosDia(horasPorSesion, tipoEntrenamiento);

        // Assert
        assertNotNull(ejerciciosDia);
        System.out.println(ejerciciosDia.size());
        assertTrue(ejerciciosDia.size() == 3);
        int totalDuracion = ejerciciosDia.stream().mapToInt(Ejercicio::getDuracion).sum();
        assertTrue(totalDuracion <= horasPorSesion * 60);
        Integer cantidadEjerciciosDeCardio = 0;
        for (Ejercicio ejercicio : ejerciciosDia) {
           if(ejercicio.getTipo() == "Cardio"){
               cantidadEjerciciosDeCardio++;
           }
        }
        assertTrue(cantidadEjerciciosDeCardio > 0);
        verify(repositorioEjercicioMock, times(1)).buscarTodosLosEjercicio();
    }

    public Set<Ejercicio> listaEjercicios(){
        Set <Ejercicio>list = new HashSet<>();
        Ejercicio ejercicio1 = new Ejercicio();
        Ejercicio ejercicio2 = new Ejercicio();
        Ejercicio ejercicio3 = new Ejercicio();
        ejercicio1.setDescripcion("correr rapido");
        ejercicio1.setDuracion(2);
        ejercicio1.setNombre("correr");
        ejercicio1.setTipo("Cardio");
        ejercicio1.setPrimario(Boolean.TRUE);
        ejercicio2.setDescripcion("correr rapido1");
        ejercicio2.setDuracion(40);
        ejercicio2.setNombre("correr1");
        ejercicio2.setTipo("Cardio");
        ejercicio2.setPrimario(Boolean.TRUE);
        ejercicio3.setDescripcion("correr rapido1");
        ejercicio3.setDuracion(40);
        ejercicio3.setNombre("correr1");
        ejercicio3.setTipo("Cardio");
        ejercicio3.setPrimario(Boolean.TRUE);
        list.add(ejercicio1);
        list.add(ejercicio2);
        list.add(ejercicio3);
        return list;
    }

}

