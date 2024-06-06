package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.ErrorPesoRegistroIsEmpty;
import com.tallerwebi.presentacion.DatosPeso;

import java.lang.reflect.Array;
import java.util.ArrayList;


public interface ServicioPeso {
    ArrayList obtenerPesosPorMes(Long usuarioId)throws ErrorPesoRegistroIsEmpty;

    void postPeso(Usuario usuario, DatosPeso datos) throws Exception;
}
