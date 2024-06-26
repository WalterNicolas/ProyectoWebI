package com.tallerwebi.dominio;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ServicioAptitudFisica {

   AptitudFisica registrarDatos(AptitudFisica aptitudFisica, String[] tipoDeEntrenamiento);
   Integer calcularEdad(String fechaNacimiento);
   Boolean sonParametrosValidos(AptitudFisica aptitudFisica);
   boolean update(AptitudFisica aptitudFisica);
}
