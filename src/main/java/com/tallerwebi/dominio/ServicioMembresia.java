package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.MembresiaNoEncontrada;

import java.util.List;

public interface ServicioMembresia {
    Membresia membresiasPorId(Long usuarioId);
    void crearMembresia(Membresia membresia);

    Membresia buscarPorId(Long id);

    Boolean eliminarPorId(Long membresiaId) throws MembresiaNoEncontrada;
}
