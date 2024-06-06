package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.ServicioMembresiaImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioMembresiaTest {

    private RepositorioMembresia repositorioMembresiaMock;
    private ServicioMembresia servicioMembresia;

    @BeforeEach
    public void init() {
        repositorioMembresiaMock = mock(RepositorioMembresia.class);
        servicioMembresia = new ServicioMembresiaImp(repositorioMembresiaMock);
    }


    @Test
    public void queSePuedanObtenerMembresias() {
        // Arrange
        Long usuarioId = 1L;
        Membresia membresia1 = new Membresia();
        Membresia membresia2 = new Membresia();
        List<Membresia> membresiasMock = Arrays.asList(membresia1, membresia2);
        when(repositorioMembresiaMock.buscarPorUsuario(usuarioId)).thenReturn(membresiasMock);
        List<Membresia> actualMembresias = servicioMembresia.membresiasPorId(usuarioId);
        assertEquals(membresiasMock, actualMembresias);
        verify(repositorioMembresiaMock, times(1)).buscarPorUsuario(usuarioId);
    }

    @Test
    public void queSePuedaCrearUnaMembresia() {
        Membresia membresia = new Membresia();
        servicioMembresia.crearMembresia(membresia);
        verify(repositorioMembresiaMock, times(1)).crearMembresia(membresia);
    }
}
