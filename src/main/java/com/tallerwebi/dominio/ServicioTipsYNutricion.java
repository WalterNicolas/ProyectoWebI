package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.NoHayArticulosDeEseTipo;
import com.tallerwebi.dominio.excepcion.NoHayInformacionDelArticulo;

import java.util.List;

public interface ServicioTipsYNutricion {
   List<Articulo> buscarTipsPorTipoDeEntrenamiento(String tipo) throws NoHayArticulosDeEseTipo;

   Articulo getArticuloPorId(Long id) throws NoHayInformacionDelArticulo;
}
