/*package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ControladorMapaTests {
    private HttpServletRequest requestMock;
    private MapaController controller;
    private HttpSession sessionMock;
    @Mock
    private ServicioMapa servicioSearchMock;
    private ServicioMembresia servicioMembresiaMock;
    private ServicioUsuario servicioUsuarioMock;
    private Membresia membresiaMock;
    private Usuario usuarioMock;

    @BeforeEach
    public void setUp() {
        servicioSearchMock = mock(ServicioMapa.class);
        servicioMembresiaMock = mock(ServicioMembresia.class);
        servicioUsuarioMock = mock(ServicioUsuario.class);
        controller = new MapaController(servicioSearchMock, servicioMembresiaMock, servicioUsuarioMock);
        requestMock = mock(HttpServletRequest.class);
        sessionMock = mock(HttpSession.class);
        membresiaMock = mock(Membresia.class);
        usuarioMock = mock(Usuario.class);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(sessionMock.getAttribute("Email")).thenReturn("usuario@example.com"); // Email válido en la sesión
        when(sessionMock.getAttribute("id")).thenReturn(1L); // ID válido en la sesión
        when(servicioUsuarioMock.buscarPorId(1L)).thenReturn(usuarioMock); // Usuario válido
        when(usuarioMock.getId()).thenReturn(1L); // ID del usuario
        when(servicioMembresiaMock.membresiasPorId(1L)).thenReturn(membresiaMock); // Membresía válida
        when(membresiaMock.getTipo()).thenReturn("PREMIUM"); // Tipo de membresía que permite acceso
    }

    @Test
    public void whenNoSeEncuentranLugaresLanzarError() throws Exception {
        // Configurar el comportamiento del mock
        when(servicioSearchMock.buscarSitios()).thenThrow(new SearchException());
        // Ejecutar el método bajo prueba
        ModelAndView modelAndView = controller.irASearch(null, requestMock);

        // Verificar el resultado
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("No hay lugares disponibles"));

        // Verificar que se llamó al método correspondiente del servicio
        verify(servicioSearchMock).buscarSitios();
    }

    @Test
    public void whenSeEncuentranLugaresLanzar() throws Exception {
        // Preparar datos de prueba
        List<Lugar> lugares = new ArrayList<>();
        lugares.add(new Lugar());
        when(servicioSearchMock.buscarSitios()).thenReturn(lugares);
        ModelAndView modelAndView = controller.irASearch(null, requestMock);

        // Verificar el resultado
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("mapaBuscador"));
        assertEquals(lugares, modelAndView.getModel().get("lugares"));
        assertEquals("usuario@example.com", modelAndView.getModel().get("Email"));
        assertEquals(1L, modelAndView.getModel().get("id"));

        // Verificar que se llamó al método correspondiente del servicio
        verify(servicioSearchMock).buscarSitios();
    }
}*/