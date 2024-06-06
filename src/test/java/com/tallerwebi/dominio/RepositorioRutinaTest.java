package com.tallerwebi.dominio;
import org.hibernate.SessionFactory;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})

public class RepositorioRutinaTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RepositorioRutina repositorioRutina;

    /*
1. buscar rutina por id de usuario
     */
    @Test
    @Transactional
    @Rollback
    public void puedoObtenerDetalleDeRutinaDeUnUsuario() {
        Long id = 1L;
        givenExisteUsuario(id);
        RutinaSemanal rutinaSemanal = whenBuscoPorIdDeUsuario(id);
        thenObtengoDetalleDeRutina(rutinaSemanal);
    }

    private void givenExisteUsuario(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        sessionFactory.getCurrentSession().save(usuario);
    }

    private RutinaSemanal whenBuscoPorIdDeUsuario(Long id) {
        return repositorioRutina.findByUsuarioId(id);
    }

    private void thenObtengoDetalleDeRutina(RutinaSemanal rutinaSemanal) {
        assertNotNull(rutinaSemanal);
    }

}
