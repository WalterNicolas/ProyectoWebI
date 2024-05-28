package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Ejercicio;
import com.tallerwebi.dominio.EjerciciosRepositorio;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import java.util.List;

@Repository
public class EjercicioRepositorioImp implements EjerciciosRepositorio {
    private SessionFactory sessionFactory;

    @Autowired
    public EjercicioRepositorioImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Ejercicio> buscarTodosLosEjercicio() {
            Session session = sessionFactory.getCurrentSession();
            Query<Ejercicio> query = session.createQuery("FROM Ejercicio", Ejercicio.class);
            return query.getResultList();
        }

}
