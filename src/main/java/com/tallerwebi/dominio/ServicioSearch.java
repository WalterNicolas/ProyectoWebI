package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioSearch {

    Double buscarDistancia(Lugar l);
    List<Lugar> buscarSitios() throws Exception;
    Lugar  filtroSitios(String input) throws  Exception;


}
