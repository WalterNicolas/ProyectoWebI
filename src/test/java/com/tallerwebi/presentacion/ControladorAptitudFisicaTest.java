package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ControladorAptitudFisicaTest {

    @Mock
    private ServicioAptitudFisica servicioAptitudFisicaMock;

    @Mock
    private RepositorioUsuario repositorioUsuarioMock;

    @InjectMocks
    private ControladorAptitudFisica controladorAptitudFisica;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcesarFormulario_ExcepcionDatosMalIngresados() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);
        Usuario usuario = new Usuario();
        String[] arrayEntrenamiento = {"prueba"};

        // Configura el mock del repositorio para devolver un usuario
        when(repositorioUsuarioMock.buscarPorId(1L)).thenReturn(usuario);

        // Configura el mock del servicio para lanzar una excepción
        when(servicioAptitudFisicaMock.registrarDatos(aptitudFisica,arrayEntrenamiento)).thenThrow(new DatosMalIngresadosException());

        ModelAndView modelAndView = controladorAptitudFisica.procesarFormulario(1L, aptitudFisica, request);

        assertEquals("formularioAptitudFisica", modelAndView.getViewName());
        assertEquals("Faltan Datos", modelAndView.getModel().get("error"));
    }

    @Test
    public void testProcesarFormulario_ExcepcionMenorDeEdad() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);
        Usuario usuario = new Usuario();
        String[] arrayEntrenamiento = {"prueba"};
        // Configura el mock del repositorio para devolver un usuario
        when(repositorioUsuarioMock.buscarPorId(1L)).thenReturn(usuario);

        // Configura el mock del servicio para lanzar una excepción
        when(servicioAptitudFisicaMock.registrarDatos(aptitudFisica,arrayEntrenamiento)).thenThrow(new esMenorDeEdadException());

        ModelAndView modelAndView = controladorAptitudFisica.procesarFormulario(1L, aptitudFisica, request);

        assertEquals("formularioAptitudFisica", modelAndView.getViewName());
        assertEquals("Tiene menos de 18 Años", modelAndView.getModel().get("error"));
    }

    @Test
    public void testProcesarFormulario_Exito() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);
        Usuario usuario = new Usuario();
        String[] arrayEntrenamiento = {"prueba"};
        // Configura el mock del repositorio para devolver un usuario
        when(repositorioUsuarioMock.buscarPorId(1L)).thenReturn(usuario);

        // Configura el mock del servicio para devolver la aptitud física
        when(servicioAptitudFisicaMock.registrarDatos(aptitudFisica,arrayEntrenamiento)).thenReturn(aptitudFisica);

        ModelAndView modelAndView = controladorAptitudFisica.procesarFormulario(1L, aptitudFisica, request);

        assertEquals("redirect:/home", modelAndView.getViewName());
    }
}