package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioMapa;
import com.tallerwebi.dominio.enums.ExerciseType;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("servicioSearch")
@Transactional
public class ServicioMapaImp implements ServicioMapa {

    private final LugarRepositorio lugarRepositorio;

    @Autowired
    public ServicioMapaImp(LugarRepositorio lugarRepositorio) {
        this.lugarRepositorio = lugarRepositorio;
    }

    @Override
    public List<Lugar> buscarSitios() {
        return lugarRepositorio.obtenerTodosLosLugares();
    }

    @Override
    public List<Lugar> buscarLugaresPorTipoActividad(Long tipoActividad) {
        return lugarRepositorio.buscarLugaresPorTipoActividad(tipoActividad);
    }
}
