package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioMapa;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ControladorMapaTests {


    private MapaController controller;

    @Mock
    private ServicioMapa servicioSearchMock;

    @BeforeEach
    public void setUp() {
        servicioSearchMock = org.mockito.Mockito.mock(ServicioMapa.class);
        controller = new MapaController(servicioSearchMock);
    }

    @Test
    public void whenNoSeEncuentranLugaresLanzarError() throws Exception {

        when(servicioSearchMock.mockDatos()).thenReturn(Collections.emptyList());
        doThrow(new SearchException()).when(servicioSearchMock).buscarSitios();

        ModelAndView modelAndView = controller.irASearch();

        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("No hay lugares disponibles"));
    }

    @Test
    public void whenSeEncuentranLugaresLanzar() throws Exception {

        List<Lugar> lugares = new ArrayList<>();

        lugares.add(new Lugar());

        when(servicioSearchMock.mockDatos()).thenReturn(lugares);
        when(servicioSearchMock.buscarSitios()).thenReturn(lugares);

        ModelAndView modelAndView = controller.irASearch();

        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertEquals(lugares, modelAndView.getModel().get("lugares"));
    }

}
