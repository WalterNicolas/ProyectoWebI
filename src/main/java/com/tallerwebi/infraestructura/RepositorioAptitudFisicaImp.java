package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.AptitudFisica;
import com.tallerwebi.dominio.RepositorioAptitudFisica;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioAptitudFisica")
public class RepositorioAptitudFisicaImp implements RepositorioAptitudFisica {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAptitudFisicaImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void guardar(AptitudFisica aptitudFisica) {
    sessionFactory.getCurrentSession().save(aptitudFisica);
    }
}
