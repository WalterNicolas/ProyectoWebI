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

public class ControladorMapaTests {

    private MapaController controller;

    @Mock
    private ServicioMapa servicioSearchMock;

    @BeforeEach
    public void setUp() {
        servicioSearchMock = mock(ServicioMapa.class);
        controller = new MapaController(servicioSearchMock);
    }

    @Test
    public void whenNoSeEncuentranLugaresLanzarError() throws Exception {
        // Configurar el comportamiento del mock
        when(servicioSearchMock.buscarSitios()).thenThrow(new SearchException());

        // Ejecutar el método bajo prueba
        ModelAndView modelAndView = controller.irASearch(null);

        // Verificar el resultado
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("No hay lugares disponibles"));

        // Verificar que se llamó al método correspondiente del servicio
        verify(servicioSearchMock).buscarSitios();
    }

    @Test
    public void whenSeEncuentranLugaresLanzar() throws Exception {
        // Crear datos de prueba
        List<Lugar> lugares = new ArrayList<>();
        lugares.add(new Lugar());

        // Configurar el comportamiento del mock
        when(servicioSearchMock.buscarSitios()).thenReturn(lugares);

        // Ejecutar el método bajo prueba
        ModelAndView modelAndView = controller.irASearch(null);

        // Verificar el resultado
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertEquals(lugares, modelAndView.getModel().get("lugares"));

        // Verificar que se llamó al método correspondiente del servicio
        verify(servicioSearchMock).buscarSitios();
    }
}