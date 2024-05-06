package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ControladorFormularioTest {
    private ControladorLogin controladorLogin;
    private Usuario usuarioMock;
    private DatosLogin datosLoginMock;
    private HttpServletRequest requestMock;
    private HttpSession sessionMock;
    private ServicioLogin servicioLoginMock;


    @BeforeEach
    public void init(){

        usuarioMock = mock(Usuario.class);
        when(usuarioMock.getEmail()).thenReturn("dami@unlam.com");
        when(usuarioMock.getPassword()).thenReturn("1234");
        requestMock = mock(HttpServletRequest.class);
        sessionMock = mock(HttpSession.class);
        servicioLoginMock = mock(ServicioLogin.class);
        controladorLogin = new ControladorLogin(servicioLoginMock);
    }
    @Test
    public void luegoDeRegistrarQueAparezcaLaPantallaFormularioAptitudFisica(){
        // preparacion
      givenNoExisteUsuario();


      thenSeAgregaAptitudFisica();
        // ejecucion
        ModelAndView modelAndView = controladorLogin.validarLogin(datosLoginMock, requestMock);

        // validacion
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("login"));
        assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("Usuario o clave incorrecta"));
        verify(sessionMock, times(0)).setAttribute("ROL", "ADMIN");
    }

    private void givenNoExisteUsuario() {
    }
    private void thenSeAgregaAptitudFisica() {
    }


}
