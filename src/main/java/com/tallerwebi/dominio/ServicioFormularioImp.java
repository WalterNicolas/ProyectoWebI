package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.EsMenorDeEdadException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;

@Service
@Transactional
public class ServicioFormularioImp implements ServicioFormulario{
    @Override
    public AptitudFisica registrarDatos(AptitudFisica aptitudFisica)  {
        if (!sonParametrosValidos(aptitudFisica)) {
            throw new DatosMalIngresadosException();
        }
        if (!esMayorDeEdad(aptitudFisica.getFechaNacimiento())) {
            throw new EsMenorDeEdadException();
        }
        return aptitudFisica;
    }

    @Override
    public Integer calcularEdad(String fechaNacimiento) {
        LocalDate fechaNacimientoDate = LocalDate.parse(fechaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimientoDate, fechaActual).getYears();
    }

    @Override
    public Boolean sonParametrosValidos(AptitudFisica aptitudFisica) {
        return aptitudFisica.getAltura() > 0
                && aptitudFisica.getPeso() > 0
                && aptitudFisica.getTipoEntrenamiento() != null
                && !aptitudFisica.getTipoEntrenamiento().isEmpty()
                && aptitudFisica.getFechaNacimiento() != null
                && !aptitudFisica.getFechaNacimiento().isEmpty()
                && aptitudFisica.getDiasEntrenamiento() > 0
                && aptitudFisica.getHorasEntrenamiento() > 0
                && aptitudFisica.getEstadoFisico() != null
                && !aptitudFisica.getEstadoFisico().isEmpty();
    }
    public Boolean esMayorDeEdad(String edad){
        if (calcularEdad(edad) >=18) {
            return true;
        }
        return false;
    }
}
