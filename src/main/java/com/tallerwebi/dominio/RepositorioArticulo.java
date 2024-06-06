package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioArticulo {
    List<Articulo> buscarPorTipoEntrenamiento(String tipoEntrenamiento);
    List<Articulo> todosLosArticulos();

    Articulo getPorId(Long id);
}
