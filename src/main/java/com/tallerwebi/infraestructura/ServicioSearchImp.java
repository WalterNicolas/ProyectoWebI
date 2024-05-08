package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioSearch;
import com.tallerwebi.dominio.enums.ExerciseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("servicioSearch")
public class ServicioSearchImp implements ServicioSearch {


    @Override
    public Double buscarDistancia(Lugar l){
        return 0.0;
    }

    @Override
    public List<Lugar> buscarSitios() throws Exception {
        List<Lugar> lugares = new ArrayList<>();

        lugares.add(new Lugar("Zona Ryp", List.of(ExerciseType.musculacion), "Ubicacion A",-34.747132079753904,-58.585186748664825));

        lugares.add(new Lugar("Taruk", List.of(ExerciseType.musculacion), "Ubicacion A",-34.74976373083753,-58.58363723032326));

        lugares.add(new Lugar("Nitro", List.of(ExerciseType.musculacion), "Ubicacion A",-34.747968651909794, -58.58560155905591));
        lugares.add(new Lugar("Vida Fit", List.of(ExerciseType.musculacion), "Ubicacion A",-34.75045468465815, -58.587086498772415));

        return lugares;
    }

    @Override
    public Lugar filtroSitios(String input) throws Exception {
        return null;
    }
}
