package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Pesaje;
import com.tallerwebi.dominio.RepositorioPesaje;
import com.tallerwebi.dominio.RepositorioRutina;
import com.tallerwebi.dominio.RutinaSemanal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPesajeImp implements RepositorioPesaje {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPesajeImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Pesaje pesaje) {
        sessionFactory.getCurrentSession().save(pesaje);
    }
}

