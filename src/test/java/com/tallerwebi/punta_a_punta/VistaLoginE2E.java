package com.tallerwebi.punta_a_punta;

import com.microsoft.playwright.*;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import com.tallerwebi.punta_a_punta.vistas.VistaLogin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})
public class VistaLoginE2E {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    VistaLogin vistaLogin;

    @BeforeAll
    static void abrirNavegador() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

    }

    @AfterAll
    static void cerrarNavegador() {
        playwright.close();
    }

    @BeforeEach
    void crearContextoYPagina() {
        context = browser.newContext();
        Page page = context.newPage();
        vistaLogin = new VistaLogin(page);
    }

    @AfterEach
    void cerrarContexto() {
        context.close();
    }

    //  @Test
    //  void deberiaDecirUNLAMEnElNavbar() {
    //      String texto = vistaLogin.obtenerTextoTitulo();
    //      assertThat("Go-Fitness", equalToIgnoringCase(texto));
    //  }

//     @Test
//     void deberiaDarUnErrorAlNoCompletarElLoginYTocarElBoton() {
//         vistaLogin.escribirEMAIL("damian@unlam.edu.ar");
//         vistaLogin.escribirClave("unlam");
//         vistaLogin.darClickEnIniciarSesion();
//         String texto = vistaLogin.obtenerMensajeDeError();
//         assertThat("Error Usuario o clave incorrecta", equalToIgnoringCase(texto));
//     }

//     @Test
//     void deberiaNavegarAlHomeSiElUsuarioExiste() {
//         vistaLogin.escribirEMAIL("test@unlam.edu.ar");
//         vistaLogin.escribirClave("test");
//         vistaLogin.darClickEnIniciarSesion();
//         String url = vistaLogin.obtenerURLActual();
//         assertThat(url, containsStringIgnoringCase("/home"));
//     }
}
