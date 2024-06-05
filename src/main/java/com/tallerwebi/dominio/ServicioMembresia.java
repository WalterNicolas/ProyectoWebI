package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioMembresia {
    Membresia membresiasPorId(Long usuarioId);
    void crearMembresia(Membresia membresia);
}
