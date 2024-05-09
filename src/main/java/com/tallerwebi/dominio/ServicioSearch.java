package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.SearchException;

import java.util.List;

public interface ServicioSearch {

    Double buscarDistancia(Lugar l);
    List<Lugar> buscarSitios() throws SearchException;
    Lugar  filtroSitios(String input) throws  Exception;
    List<Lugar> mockDatos();


}
