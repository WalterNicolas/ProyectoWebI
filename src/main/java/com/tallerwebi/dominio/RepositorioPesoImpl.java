package com.tallerwebi.dominio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class RepositorioPesoImpl implements RepositorioPeso {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPesoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(PesoRegistro pesoRegistro) {
        Session session = sessionFactory.getCurrentSession();
        session.save(pesoRegistro);
    }

    @Override
    public List<PesoRegistro> findByUsuarioId(Long usuarioId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM PesoRegistro WHERE usuario.id = :usuarioId";
        return session.createQuery(hql, PesoRegistro.class)
                .setParameter("usuarioId", usuarioId)
                .list();
    }
}