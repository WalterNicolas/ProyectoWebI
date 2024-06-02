package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioMembresia {
    List<Membresia> membresiasPorId(Long usuarioId);
    void crearMembresia(Membresia membresia);
}
