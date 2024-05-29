package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RutinaDiaria;
import com.tallerwebi.dominio.RutinaSemanal;
import com.tallerwebi.dominio.RepositorioRutinaSemanal;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class RepositorioRutinaSemanalImp implements RepositorioRutinaSemanal {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRutinaSemanalImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardar(RutinaSemanal rutinaSemanal) {
        sessionFactory.getCurrentSession().save(rutinaSemanal);

    }
    public RutinaSemanal buscarPorIdDeUsuario(Long idUsuario) {
        Session session = sessionFactory.openSession();
        Query<RutinaSemanal> query = session.createQuery("SELECT rs FROM Usuario u " +
                "JOIN u.rutinaSemanal rs " +
                "JOIN FETCH rs.rutinaDiaria rd " +
                "JOIN FETCH rd.ejercicios " +
                "WHERE u.id = :idUsuario", RutinaSemanal.class);
        query.setParameter("idUsuario", idUsuario);
        return query.uniqueResult();
    }

}
