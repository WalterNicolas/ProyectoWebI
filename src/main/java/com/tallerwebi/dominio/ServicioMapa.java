package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicioMapa {
    List<Lugar> buscarSitios();
    List<Lugar> buscarLugaresPorTipoActividad(Long tipoActividad);
}
