package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Ejercicio;
import com.tallerwebi.dominio.RepositorioEjercicio;
import com.tallerwebi.dominio.RutinaSemanal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEjercicioImp implements RepositorioEjercicio {
    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioEjercicioImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardar(Ejercicio ejercicio) {
        sessionFactory.getCurrentSession().save(ejercicio);
    }

    @Override
    public Ejercicio buscarPorId(Long id) {
        return   sessionFactory.getCurrentSession().find(Ejercicio.class, id);
    }
}
