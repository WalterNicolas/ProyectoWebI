package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioRutinas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.mock;

public class ControladorMisRutinasTest {

    private ControladorMisRutinas myRoutinesController;
    private ServicioRutinas servicioRoutinesMock;

    @BeforeEach
    public void init(){
        servicioRoutinesMock = mock(ServicioRutinas.class);
        myRoutinesController = new ControladorMisRutinas(servicioRoutinesMock);
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
        return  myRoutinesController.verMisRutinas();
    }

    private void thenVistaResumenRutinaExitosa(ModelAndView mav) {
        assertThat(mav.getViewName(), equalToIgnoringCase("my-routines"));
    }
}

