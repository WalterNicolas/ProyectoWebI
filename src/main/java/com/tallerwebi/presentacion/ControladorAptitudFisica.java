package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.DatosMalIngresadosException;
import com.tallerwebi.dominio.excepcion.esMenorDeEdadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ControladorAptitudFisica {
    @Autowired
    private final ServicioAptitudFisica servicioAptitudFisica;
    @Autowired
    private final RepositorioUsuario repositorioUsuario;
    public ControladorAptitudFisica(ServicioAptitudFisica servicioAptitudFisica, RepositorioUsuario repositorioUsuario) {

        this.servicioAptitudFisica = servicioAptitudFisica;
        this.repositorioUsuario = repositorioUsuario;
    }

    @RequestMapping("/formularioAptitudFisica")
    public ModelAndView irAFormulario() {
        ModelMap modelo = new ModelMap();
        modelo.put("aptitudFisica", new AptitudFisica());
        return new ModelAndView("formularioAptitudFisica", modelo);
    }

    @RequestMapping(path = "/{id}/guardar-aptitud-fisica", method = RequestMethod.POST)
    @Transactional
    public ModelAndView procesarFormulario(@PathVariable Long id, @ModelAttribute("aptitudFisica") AptitudFisica aptitudFisica, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        try {
            Usuario usuario = repositorioUsuario.buscarPorId(id);
            if (usuario == null) {
                return registroFallido(model, "Usuario no encontrado");
            }

            String[] tiposEntrenamiento = request.getParameterValues("tiposEntrenamiento");


            aptitudFisica.setUsuario(usuario);
            AptitudFisica apto = servicioAptitudFisica.registrarDatos(aptitudFisica,tiposEntrenamiento);

            usuario.setAptitudFisica(aptitudFisica);
            repositorioUsuario.guardar(usuario);

            model.put("aptitudFisica", apto);
            return registroExitoso(model);
        } catch (DatosMalIngresadosException ex) {
            return registroFallido(model, "Faltan Datos");
        } catch (esMenorDeEdadException ex) {
            return registroFallido(model, "Tiene menos de 18 Años");
        }
    }

    private ModelAndView registroFallido(ModelMap model, String mensaje) {
        model.put("error", mensaje);
        return new ModelAndView("formularioAptitudFisica", model);
    }

    private ModelAndView registroExitoso(ModelMap model) {

        return new ModelAndView("redirect:/home");
    }
}