package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DatosPeso;

import java.lang.reflect.Array;
import java.util.ArrayList;


public interface ServicioPeso {
    ArrayList obtenerPesosPorMes(Long usuarioId);

    void postPeso(Usuario usuario, DatosPeso datos);
}
