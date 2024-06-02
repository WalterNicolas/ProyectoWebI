package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioRutinaSemanal {
    void guardar(RutinaSemanal rutinaSemanal);
    RutinaSemanal buscarPorIdDeUsuario(Long id);
}
