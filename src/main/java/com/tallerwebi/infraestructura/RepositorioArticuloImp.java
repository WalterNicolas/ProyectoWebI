package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Articulo;
import com.tallerwebi.dominio.RepositorioArticulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioArticuloImp implements RepositorioArticulo {
    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioArticuloImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Articulo> buscarPorTipoEntrenamiento(String tipoEntrenamiento) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Articulo where tipoEntrenamiento = :tipoEntrenamiento", Articulo.class)
                .setParameter("tipoEntrenamiento", tipoEntrenamiento)
                .list();
    }
    @Override
    public List<Articulo> todosLosArticulos() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Articulo", Articulo.class).list();
    }

    @Override
    public Articulo getPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Articulo.class, id);
    }
}
