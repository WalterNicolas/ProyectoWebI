package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicioMapa {
    List<Lugar> buscarSitios() throws SearchException;
    List<Lugar> buscarLugaresPorTipoActividad(Long tipoActividad) throws SearchException;
    List<Lugar> filtrarLugaresPorDistancia(List<Lugar> lugares, double latitudUsuario, double longitudUsuario, int distancia);
}
