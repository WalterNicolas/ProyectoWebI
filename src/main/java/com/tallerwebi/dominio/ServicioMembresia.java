package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioMembresia {
    Membresia buscarPorTipo(String tipo);
    List<Membresia> membresiasPorId(Long usuarioId);
    void crearMembresia(Membresia membresia);
}
