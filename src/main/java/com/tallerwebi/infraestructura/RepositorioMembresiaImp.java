package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Articulo;
import com.tallerwebi.dominio.Membresia;
import com.tallerwebi.dominio.RepositorioMembresia;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RepositorioMembresiaImp implements RepositorioMembresia {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioMembresiaImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Membresia buscarPorTipo(String tipo) {
        final Session session = sessionFactory.getCurrentSession();
        return (Membresia) session.createCriteria(Membresia.class)
                .add(Restrictions.eq("tipo", tipo))
                .uniqueResult();
    }

    @Override
    public Membresia buscarPorUsuario(Long usuarioId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Membresia where usuario_id = :usuarioId", Membresia.class)
                .setParameter("usuarioId", usuarioId)
                .uniqueResult();
    }

    @Override
    public void crearMembresia(Membresia membresia) {
        sessionFactory.getCurrentSession().save(membresia);
    }

}
