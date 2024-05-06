package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ControladorLogin;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import net.bytebuddy.asm.Advice;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.mock;

public class ServicioFormularioAptitudFisicaTest {
    ServicioFormulario servicioFormulario;
    /*
    1. si es menor de edad que no se pueda registrar
    2.todos los datos deben estar correctos
     */
    @BeforeEach
    public void init(){
        servicioFormulario = new ServicioFormularioImp();


    }
    @Test
    public void siLosDatosSonBienIngresadosQueDevuelvaAptitudFisica(){
        givenNoHayDatos();
        AptitudFisica apto =  whenLosDatosSonCorrectos();
        thenRetornaAptitudFisica(apto);

    }

    private void givenNoHayDatos() {
    }
    private AptitudFisica whenLosDatosSonCorrectos() {
        AptitudFisica apto = new AptitudFisica();
        apto.setAltura(185);
        apto.setPeso(100.5);
        LocalDate fechaDeNacimiento = LocalDate.of(1994, 1, 31);

        // Crear un objeto DateTimeFormatter para el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convertir la fecha de nacimiento a String
        String fechaDeNacimientoString = fechaDeNacimiento.format(formato);
        apto.setFechaNacimiento(fechaDeNacimientoString);
        apto.setTipoEntrenamiento("Gym");
        apto.setDiasEntrenamiento(3);
        apto.setHorasEntrenamiento(1);
        apto.setEstadoFisico("sedentario");
      return   servicioFormulario.registrarDatos(apto);
    }

    private void thenRetornaAptitudFisica(AptitudFisica apto) {
        assertThat(apto,notNullValue());
        assertThat(apto.getAltura(),equalTo(185));
    }

}
