package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.mock;

public class ControladorFormAptitudFisicaTest {

    private ControladorAptitudFisica controladorFormulario;
    private ControladorLogin controladorLogin;
    private ServicioLogin servicioLoginMock;


    @BeforeEach
    public void init(){
        servicioLoginMock = mock(ServicioLogin.class);
        controladorLogin = new ControladorLogin(servicioLoginMock);
    }
    @Test
    public void queLuegoDeRegistrarmeMeLLeveAlFormularioDeAptitudFisica(){
        givenUsuarioRegistrado();
        Usuario usuario = new Usuario ();
        usuario.setEmail("nico@nico.com");
        usuario.setPassword("12345678");
        ModelAndView mav = whenMeRegistro(usuario);
        thenVistaFormularioExitosa(mav);
    }

    private void givenUsuarioRegistrado() {
    }
    private ModelAndView whenMeRegistro(Usuario usuario) {
     return  controladorLogin.registrarme(usuario);
    }
    private void thenVistaFormularioExitosa(ModelAndView mav) {
        assertThat(mav.getViewName(), equalToIgnoringCase("aptitud-fisica"));
    }
}
