package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DatosDiasYEjercicios;
import com.tallerwebi.presentacion.DatosPeso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicioPesoImpl implements ServicioPeso{

    @Autowired
    public RepositorioPeso repositorioPeso;

    @Override
    public ArrayList<Double> obtenerPesosPorMes(Long usuarioId) {
        List<PesoRegistro> pesoRegistro = this.repositorioPeso.findByUsuarioId(usuarioId);

        Map<Integer, Double> pesosPorMes = new HashMap<>();

        for (PesoRegistro p : pesoRegistro) {
            LocalDate fecha = p.getFecha();
            int mes = fecha.getMonthValue();
            double peso = p.getPeso();
            pesosPorMes.put(mes, peso);
        }

        ArrayList<Double> pesosOrdenadosPorMes = new ArrayList<>();

        int mesActual = LocalDate.now().getMonthValue();

        for (int i = 1; i <= 12; i++) {
            if (i > mesActual) {
                break;
            }

            if (pesosPorMes.containsKey(i)) {
                pesosOrdenadosPorMes.add(pesosPorMes.get(i));
            } else {
                if (i > 1) {
                    double pesoAnterior = pesosOrdenadosPorMes.get(i - 2);
                    pesosOrdenadosPorMes.add(pesoAnterior);
                } else {
                    pesosOrdenadosPorMes.add(0.0);
                }
            }
        }

        return pesosOrdenadosPorMes;
    }


    @Override
    public void postPeso(Usuario usuario, DatosPeso datos) {
        PesoRegistro newRegistro = new PesoRegistro(usuario,datos.getFecha(),datos.getPeso());
        this.repositorioPeso.save(newRegistro);
    }
}
