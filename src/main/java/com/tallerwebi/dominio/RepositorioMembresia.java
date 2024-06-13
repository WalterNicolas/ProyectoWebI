package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioMembresia {
    Membresia buscarPorTipo(String tipoMembresia);
    Membresia buscarPorUsuario(Long usuarioId);
    void crearMembresia(Membresia membresia);
}

