package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import com.tallerwebi.presentacion.DataModel.Ejercicio;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioRutinasImp implements ServicioRutinas {

    @Override
    public List<Ejercicio> cargarEjercicios(List<Ejercicio> listaEjercicios){
        DetalleRutina detalleRutina = new DetalleRutina();
        detalleRutina.setListaEjercicios(listaEjercicios);
        return detalleRutina.getListaEjercicios();
    }

    @Override
    public Integer contarEjerciciosCumplidos(DetalleRutina detalleRutina){
        Integer ejerciciosCumplidos=0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null){
            for(Ejercicio actual : detalleRutina.getListaEjercicios()){
                if (actual.getRealizado().equals(true)) {
                    ejerciciosCumplidos++;
                }
            }
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
    public Integer contarEjerciciosporHacer(DetalleRutina detalleRutina){
        Integer ejerciciosPorHacer=0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null) {
            for (Ejercicio actual : detalleRutina.getListaEjercicios()) {
                if (actual.getRealizado().equals(false)) {
                    ejerciciosPorHacer++;
                }
            }
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
