package com.tallerwebi.dominio;

public interface ServicioAptitudFisica {

   AptitudFisica registrarDatos(AptitudFisica aptitudFisica);
   Integer calcularEdad(String fechaNacimiento);
   Boolean sonParametrosValidos(AptitudFisica aptitudFisica);
}
