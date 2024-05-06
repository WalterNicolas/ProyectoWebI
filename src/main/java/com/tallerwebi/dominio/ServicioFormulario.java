package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;

public interface ServicioFormulario {

   AptitudFisica registrarDatos(AptitudFisica aptitudFisica) throws DatosMalIngresadosException;
   Integer calcularEdad(String fechaNacimiento);
   Boolean sonParametrosValidos(AptitudFisica aptitudFisica);
}
