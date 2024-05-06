package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioFormulario;
import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller

public class ControladorFormulario {
    ServicioFormulario servicioFormulario;

    public ControladorFormulario(ServicioFormulario servicioFormulario){
        this.servicioFormulario = servicioFormulario;
    }
/**
    @RequestMapping("/formulario")
    public ModelAndView irAFormulario() {
        ModelMap modelo = new ModelMap();
        modelo.put("aptitudFisica", new AptitudFisica());
        return new ModelAndView("formulario", modelo);
    }
 */
   @RequestMapping (path="/guardar-aptitud-fisica", method = RequestMethod.POST)
    public ModelAndView procesarFormulario(@ModelAttribute("aptitudFisica") AptitudFisica aptitudFisica, HttpServletRequest request) {
        // Aquí puedes procesar los datos recibidos del formulario
       ModelMap model = new ModelMap();
       try {
           AptitudFisica apto = servicioFormulario.registrarDatos(aptitudFisica);
           model.put("aptitudFisica",apto);
       } catch (DatosMalIngresadosException ex) {
           return registroFallido(model, "Faltan Datos");
       }
       catch (esMenorDeEdadException ex) {
           return registroFallido(model, "Tiene menos de 18 Anos");
       }
       return registroExitoso(model);
    }

    private ModelAndView registroFallido(ModelMap model, String mensaje) {
        model.put("error",mensaje);
        return new ModelAndView("formulario",model);
    }

    private ModelAndView registroExitoso(ModelMap model) {
        return new ModelAndView("home",model);
    }
}
