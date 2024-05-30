package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRutinaImp implements RepositorioRutina {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRutinaImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(RutinaSemanal rutinaSemanal) {
        sessionFactory.getCurrentSession().save(rutinaSemanal);
    }

    @Override
    public void guardarRutinaActualizada(DetalleRutina detalleRutina) {
        sessionFactory.getCurrentSession().save(detalleRutina);
    }
}

