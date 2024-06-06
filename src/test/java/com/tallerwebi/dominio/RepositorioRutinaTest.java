package com.tallerwebi.dominio;

import com.mysql.cj.xdevapi.SessionFactory;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})

public class RepositorioRutinaTest {
    @Autowired
    private SessionFactory sessionFactory;

        /*
    1. buscar rutina por id de usuario
         */
    @Test
    public void puedoObtenerDetalleDeRutinaDeUnUsuario() {
        givenExisteUsuario();
        whenBuscoUsuarioPorId();
        thenObtengoDetalleDeRutina();

    }

    private void givenExisteUsuario() {
    }

    private void whenBuscoUsuarioPorId() {
    }

    private void thenObtengoDetalleDeRutina() {
    }

}
