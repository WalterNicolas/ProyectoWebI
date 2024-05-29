package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.AptitudFisica;
import com.tallerwebi.dominio.RutinaSemanal;
import com.tallerwebi.dominio.RepositorioRutina;
import com.tallerwebi.dominio.Usuario;
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
}

