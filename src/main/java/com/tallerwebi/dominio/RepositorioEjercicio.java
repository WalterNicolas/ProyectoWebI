package com.tallerwebi.dominio;

public interface RepositorioEjercicio {
    void guardar(Ejercicio ejercicio);
    Ejercicio buscarPorId(Long id);
}
