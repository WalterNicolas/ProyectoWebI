package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioFormulario;
import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
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
    private ServicioFormulario servicioFormularioMock;

    @InjectMocks
    private ControladorAptitudFisica controladorFormulario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcesarFormulario_ExcepcionDatosMalIngresados() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(servicioFormularioMock.registrarDatos(aptitudFisica)).thenThrow(new DatosMalIngresadosException());

        ModelAndView modelAndView = controladorFormulario.procesarFormulario(aptitudFisica, request);

        assertEquals("formularioAptitudFisica", modelAndView.getViewName());
        assertEquals("Faltan Datos", modelAndView.getModel().get("error"));
    }

    @Test
    public void testProcesarFormulario_ExcepcionMenorDeEdad() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(servicioFormularioMock.registrarDatos(aptitudFisica)).thenThrow(new esMenorDeEdadException());

        ModelAndView modelAndView = controladorFormulario.procesarFormulario(aptitudFisica, request);

        assertEquals("formularioAptitudFisica", modelAndView.getViewName());
        assertEquals("Tiene menos de 18 Anos", modelAndView.getModel().get("error"));
    }

    @Test
    public void testProcesarFormulario_Exito() throws DatosMalIngresadosException, esMenorDeEdadException {
        AptitudFisica aptitudFisica = new AptitudFisica();
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(servicioFormularioMock.registrarDatos(aptitudFisica)).thenReturn(aptitudFisica);

        ModelAndView modelAndView = controladorFormulario.procesarFormulario(aptitudFisica, request);

        assertEquals("home", modelAndView.getViewName());
    }
}