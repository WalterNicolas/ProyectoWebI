package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioFormulario;
import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.EsMenorDeEdadException;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller

public class ControladorAptitudFisica {
    private final ServicioFormulario servicioFormulario;

    public ControladorAptitudFisica(ServicioFormulario servicioFormulario) {
        this.servicioFormulario = servicioFormulario;
    }

    @RequestMapping("/aptitud-fisica")
    public ModelAndView irAFormulario() {
        ModelMap modelo = new ModelMap();
        modelo.put("aptitudFisica", new AptitudFisica());
        return new ModelAndView("aptitud-fisica", modelo);
    }

    @RequestMapping(path = "/guardar-aptitud-fisica", method = RequestMethod.POST)
    public ModelAndView procesarFormulario(@ModelAttribute("aptitudFisica") AptitudFisica aptitudFisica, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        try {
            AptitudFisica apto = servicioFormulario.registrarDatos(aptitudFisica);
            model.put("aptitudFisica", apto);
            return registroExitoso(model);
        } catch (DatosMalIngresadosException ex) {
            return registroFallido(model, "Faltan Datos");
        } catch (EsMenorDeEdadException ex) {
            return registroFallido(model, "Tiene menos de 18 Anos");
        }
    }

    private ModelAndView registroFallido(ModelMap model, String mensaje) {
        model.put("error", mensaje);
        return new ModelAndView("aptitud-fisica", model);
    }

    private ModelAndView registroExitoso(ModelMap model) {
        return new ModelAndView("home", model);
    }
}