package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.UsuarioInexistenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ControladorMembresiaTest {

    private ServicioLogin servicioLoginMock;
    private ServicioMembresia servicioMembresiaMock;
    private ServicioRutina servicioRutinaMock;
    private HttpServletRequest request;
    private HttpSession session;
    private ControladorMembresia controladorMembresia;

    @BeforeEach
    public void init() {
        servicioLoginMock = mock(ServicioLogin.class);
        servicioMembresiaMock = mock(ServicioMembresia.class);
        servicioRutinaMock = mock(ServicioRutina.class);
        session = mock(HttpSession.class);
        request = mock(HttpServletRequest.class);

        controladorMembresia = new ControladorMembresia(servicioLoginMock,servicioMembresiaMock,servicioRutinaMock); // Instancia real del controlador

        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("Email")).thenReturn("test@example.com");
    }

    @Test
    public void testAsignarMembresiaUsuarioExistente() throws UsuarioInexistenteException {
        // Arrange
        String email = "usuario@example.com";
        String tipo = "Premium";
        int duracion = 6;
        RutinaSemanal rutinaSemanal = new RutinaSemanal();
        Usuario usuario=  givenUsuarioCreado(email);
        ModelAndView mav = whenSeAsignaMembresia(email,usuario,tipo,duracion,rutinaSemanal);
        thenVuelvoHomeConModeloMembresiaYMas(mav,usuario,rutinaSemanal);
    }

    private ModelAndView whenSeAsignaMembresia(String email, Usuario usuario, String tipo,int duracion,RutinaSemanal rutinaSemanal) throws UsuarioInexistenteException {
        when(servicioLoginMock.buscarPorMail(email)).thenReturn(usuario);
        doNothing().when(servicioMembresiaMock).crearMembresia(any(Membresia.class));
        when(servicioRutinaMock.generarRutinaSemanal(usuario)).thenReturn(rutinaSemanal);
       return controladorMembresia.asignarMembresia(tipo, email, duracion, request);
    }
    public void   thenVuelvoHomeConModeloMembresiaYMas(ModelAndView mav,Usuario usuario,RutinaSemanal rutinaSemanal) {
        assertNotNull(mav);
        assertEquals("home", mav.getViewName());
        ModelMap modelo = mav.getModelMap();
        assertNotNull(modelo);
        assertEquals(usuario, modelo.get("usuario"));
        assertNotNull(modelo.get("membresia"));
        assertEquals(rutinaSemanal, modelo.get("rutinaSemanal"));
        assertEquals("test@example.com", modelo.get("Email"));
    }
    private Usuario givenUsuarioCreado(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        return usuario;
    }

    @Test
    public void testAsignarMembresiaUsuarioInexistente() throws UsuarioInexistenteException {
        // Arrange
        String email = "usuario_inexistente@example.com";
        String tipo = "Premium";
        int duracion = 6;


        when(servicioLoginMock.buscarPorMail(email)).thenThrow(new UsuarioInexistenteException("Usuario no encontrado"));
        Usuario usuario=  givenUsuarioCreado(email);
        ModelAndView mav = controladorMembresia.asignarMembresia(tipo, email, duracion, request);
        thenDevuelvoErrorNoQueNoExisteUsuarioRegistrado(mav);
    }
    public void   thenDevuelvoErrorNoQueNoExisteUsuarioRegistrado(ModelAndView mav){
        System.out.println(mav);
        ModelMap modelo = mav.getModelMap();
        assertNotNull(mav);
        assertEquals("home", mav.getViewName());
        assertEquals("Usuario no encontrado", modelo.get("error"));
    }
}
