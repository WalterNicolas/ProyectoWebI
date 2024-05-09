package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.BusquedaException;

import java.util.List;

public interface ServicioBusqueda {

    Double buscarDistancia(Lugar l);
    List<Lugar> buscarSitios() throws BusquedaException;
    Lugar  filtroSitios(String input) throws  Exception;
    List<Lugar> mockDatos();


}
