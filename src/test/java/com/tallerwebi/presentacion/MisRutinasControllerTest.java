package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioRutina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.mock;

public class MisRutinasControllerTest {

    private MisRutinasController myRoutinesController;
    private ServicioRutina servicioRutinaMock;
    private HttpServletRequest requestMock;
    @BeforeEach
    public void init(){
        servicioRutinaMock = mock(ServicioRutina.class);
        myRoutinesController = new MisRutinasController(servicioRutinaMock);
        requestMock = mock(HttpServletRequest.class);
    }
    @Test
    public void queMuestreElResumenDeRutina(){
        givenExisteRutina();
//        DetalleRutina detalleRutina = new DetalleRutina ();
//        Ejercicio unEjercicio = new Ejercicio ();
//        Ejercicio otroEjercicio = new Ejercicio ();
//        detalleRutina.addEjercicio(unEjercicio);
//        detalleRutina.addEjercicio(otroEjercicio);
        ModelAndView mav = whenVerMisRutinas();
        thenVistaResumenRutinaExitosa(mav);
    }

    private void givenExisteRutina() {
    }

    private ModelAndView whenVerMisRutinas() {
        return  myRoutinesController.verMisRutinas(requestMock);
    }

    private void thenVistaResumenRutinaExitosa(ModelAndView mav) {
        assertThat(mav.getViewName(), equalToIgnoringCase("misRutinas"));
    }
}

