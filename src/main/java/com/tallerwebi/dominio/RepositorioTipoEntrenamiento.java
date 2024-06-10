package com.tallerwebi.dominio;

public interface RepositorioTipoEntrenamiento {
     void guardar(AptitudFisica aptitudFisica);
    void guardarRelacion(Long aptitudFisicaId, Long tipoEntrenamientoId);

    public TipoEntrenamiento findByNombre(String nombre);
}
