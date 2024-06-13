package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.RutinaSemanalVacia;

import java.util.List;

public interface RepositorioRutinaSemanal {
    void guardar(RutinaSemanal rutinaSemanal);
    RutinaSemanal buscarPorIdDeUsuario(Long id) throws RutinaSemanalVacia;

    public List<RutinaSemanal> obtenerTodasLasRutinasById(Long idUsuario) throws RutinaSemanalVacia;
}
