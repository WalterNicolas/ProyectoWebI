package com.tallerwebi.dominio;

public interface RepositorioAptitudFisica
{
    void guardar(AptitudFisica aptitudFisica);

    boolean update(AptitudFisica aptitudFisica);
}