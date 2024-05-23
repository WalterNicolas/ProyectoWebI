package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.ServicioRutina;
import com.tallerwebi.dominio.excepcion.NoHayEjerciciosCargadosException;
import com.tallerwebi.dominio.DetalleRutina;
import com.tallerwebi.dominio.Ejercicio;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioRutinaImp implements ServicioRutina {

    @Override
    public List<Ejercicio> cargarEjercicios(List<Ejercicio> listaEjercicios){
        DetalleRutina detalleRutina = new DetalleRutina();
        detalleRutina.setListaEjercicios(listaEjercicios);
        return detalleRutina.getListaEjercicios();
    }

    @Override
    public Integer contarEjerciciosCumplidos(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        Integer ejerciciosCumplidos=0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null){
            for(Ejercicio actual : detalleRutina.getListaEjercicios()){
                if (actual.getRealizado().equals(true)) {
                    ejerciciosCumplidos++;
                }
            }
        }
        else {
            throw new NoHayEjerciciosCargadosException();
        }
        return ejerciciosCumplidos;
    }

    @Override
    public Double calcularDiferenciaDeKilos(Double pesoInicial, Double pesoActual){
        Double difPeso;
        difPeso= pesoInicial - pesoActual;
        return difPeso;
    }

    @Override
    public Integer contarEjerciciosporHacer(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        Integer ejerciciosPorHacer=0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null) {
            for (Ejercicio actual : detalleRutina.getListaEjercicios()) {
                if (actual.getRealizado().equals(false)) {
                    ejerciciosPorHacer++;
                }
            }
        }
        else {
            throw new NoHayEjerciciosCargadosException();
        }
        return ejerciciosPorHacer;
    }

    @Override
    public Double calcularIMC(Double peso,Double altura){
        Double imc=0.0;
        imc=peso/(altura*altura);
        return imc;
    }
}
