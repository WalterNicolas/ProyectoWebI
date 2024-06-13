package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RutinaDiaria;
import com.tallerwebi.dominio.RutinaSemanal;
import com.tallerwebi.dominio.RepositorioRutinaSemanal;
import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.excepcion.RutinaSemanalVacia;
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
    public List<RutinaSemanal> buscarPorIdDeUsuario(Long idUsuario){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RutinaSemanal> criteriaQuery = builder.createQuery(RutinaSemanal.class);
        Root<RutinaSemanal> rutinaSemanalRoot = criteriaQuery.from(RutinaSemanal.class);

        // Crear un join con Usuario para establecer la condición
        Join<RutinaSemanal, Usuario> usuarioJoin = rutinaSemanalRoot.join("usuario");

        // Establecer la condición WHERE
        criteriaQuery.where(builder.equal(usuarioJoin.get("id"), idUsuario));

        // Ejecutar la consulta y obtener los resultados
        Query<RutinaSemanal> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<RutinaSemanal> obtenerTodasLasRutinasById(Long idUsuario) throws RutinaSemanalVacia {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RutinaSemanal> criteriaQuery = criteriaBuilder.createQuery(RutinaSemanal.class);
        Root<RutinaSemanal> root = criteriaQuery.from(RutinaSemanal.class);
        Join<RutinaSemanal, Usuario> usuarioJoin = root.join("usuario");
        criteriaQuery.select(root).where(criteriaBuilder.equal(usuarioJoin.get("id"), idUsuario));
        var results = session.createQuery(criteriaQuery).getResultList();
        if  (results == null || results.size() == 0) throw new RutinaSemanalVacia("No se encontró una rutina");
        return results ;
    }

}
