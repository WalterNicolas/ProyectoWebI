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
    public void cuandoNoSeEncuentranLugaresDeberiaLanzarError() throws Exception {
        // Configurar el comportamiento del mock cuando el servicio busca lugares y no encuentra ninguno
        when(servicioSearchMock.buscarSitios()).thenReturn(Collections.emptyList());

        // Ejecutar el método bajo prueba
        ModelAndView mav = controller.irASearch(null, null, requestMock);

        // Verificar el resultado esperado
        assertEquals("datos", mav.getViewName()); // Debe redirigir a "datos" por falta de acceso
        assertEquals("No tienes acceso a esta sección. Actualice su Membresia", mav.getModel().get("error"));
    }

    @Test
    public void cuandoHayLugaresEncontradosDeberiaMostrarLista() throws Exception {
        // Configurar el comportamiento del mock cuando el servicio busca lugares y encuentra algunos
        List<Lugar> lugaresMock = new ArrayList<>();
        lugaresMock.add(new Lugar("Gimnasio A", "Dirección A", -34.750, -58.570));
        lugaresMock.add(new Lugar("Piscina B", "Dirección B", -34.755, -58.575));
        when(servicioSearchMock.buscarSitios()).thenReturn(lugaresMock);

        // Ejecutar el método bajo prueba
        ModelAndView mav = controller.irASearch(null, null, requestMock);

        // Verificar el resultado esperado
        assertEquals("mapaBuscador", mav.getViewName()); // Debe mostrar la vista "mapaBuscador"
        assertEquals(lugaresMock, mav.getModel().get("lugares")); // Debe contener la lista de lugares encontrados
    }
@Test
public void cuandoFiltroPorTipoActividadDeberiaMostrarLugaresFiltrados() throws Exception {
    // Configurar el comportamiento del mock para buscar lugares por tipo de actividad
    Long tipoActividadId = 1L; // Supongamos que 1L representa la actividad de Musculación
    List<Lugar> lugaresMock = new ArrayList<>();
    lugaresMock.add(new Lugar("Gimnasio A", "Dirección A", -34.750, -58.570));
    when(servicioSearchMock.buscarLugaresPorTipoActividad(tipoActividadId)).thenReturn(lugaresMock);

    // Ejecutar el método bajo prueba con el tipo de actividad especificado
    ModelAndView mav = controller.irASearch(tipoActividadId.toString(), null, requestMock);

    // Verificar el resultado esperado
    assertEquals("mapaBuscador", mav.getViewName()); // Debe mostrar la vista "mapaBuscador"
    assertEquals(lugaresMock, mav.getModel().get("lugares")); // Debe contener la lista de lugares filtrados por tipo de actividad
}

@Test
public void cuandoFiltroPorDistanciaDeberiaMostrarLugaresEnRadioElegido() throws Exception {
    // Configurar el comportamiento del mock para buscar lugares sin filtrar inicialmente
    List<Lugar> lugaresMock = new ArrayList<>();
    lugaresMock.add(new Lugar("Gimnasio A", "Dirección A", -34.750, -58.570));
    lugaresMock.add(new Lugar("Piscina B", "Dirección B", -34.755, -58.575));
    when(servicioSearchMock.buscarSitios()).thenReturn(lugaresMock);

    // Configurar el comportamiento del mock para filtrar lugares por distancia
    double latitudUsuario = -34.749;
    double longitudUsuario = -58.571;
    int distanciaSeleccionada = 10; // Se elige una distancia de 10 km
    List<Lugar> lugaresFiltradosMock = new ArrayList<>();
    lugaresFiltradosMock.add(new Lugar("Gimnasio A", "Dirección A", -34.750, -58.570)); // Este lugar está dentro de 10 km
    when(servicioSearchMock.filtrarLugaresPorDistancia(lugaresMock, latitudUsuario, longitudUsuario, distanciaSeleccionada))
            .thenReturn(lugaresFiltradosMock);

    // Ejecutar el método bajo prueba con la distancia seleccionada
    ModelAndView mav = controller.irASearch(null, distanciaSeleccionada, requestMock);

    // Verificar el resultado esperado
    assertEquals("mapaBuscador", mav.getViewName()); // Debe mostrar la vista "mapaBuscador"
    assertEquals(lugaresFiltradosMock, mav.getModel().get("lugares")); // Debe contener la lista de lugares filtrados por distancia
}

@Test
public void cuandoNoHayUsuarioLogueadoDeberiaDefinirUbicacionPorDefecto() throws Exception {
    // Configurar el comportamiento del mock para obtener sesión nula (usuario no logueado)
    when(requestMock.getSession(false)).thenReturn(null);

    // Ejecutar el método bajo prueba cuando no hay sesión activa
    ModelAndView mav = controller.irASearch(null, null, requestMock);

    // Verificar el resultado esperado
    assertEquals("mapaBuscador", mav.getViewName()); // Debe mostrar la vista "mapaBuscador"
    assertEquals(-34.74973643128108, mav.getModel().get("latitudUsuario")); // Latitud por defecto
    assertEquals(-58.571734784656066, mav.getModel().get("longitudUsuario")); // Longitud por defecto
}

@Test
public void cuandoNoHayLugaresCercaDeUsuarioDeberiaMostrarMensaje() throws Exception {
    // Configurar el comportamiento del mock para obtener lugares vacíos después del filtrado por distancia
    List<Lugar> lugaresMock = new ArrayList<>();
    double latitudUsuario = -34.749;
    double longitudUsuario = -58.571;
    int distanciaSeleccionada = 5; // Se elige una distancia de 5 km
    when(servicioSearchMock.buscarSitios()).thenReturn(Collections.emptyList());
    when(servicioSearchMock.filtrarLugaresPorDistancia(lugaresMock, latitudUsuario, longitudUsuario, distanciaSeleccionada))
            .thenReturn(Collections.emptyList());

    // Ejecutar el método bajo prueba con la distancia seleccionada
    ModelAndView mav = controller.irASearch(null, distanciaSeleccionada, requestMock);

    // Verificar el resultado esperado
    assertEquals("datos", mav.getViewName()); // Debe redirigir a "datos" por falta de lugares cerca
    assertEquals("No hay lugares cercanos a tu ubicación actual.", mav.getModel().get("error"));
}
}*/