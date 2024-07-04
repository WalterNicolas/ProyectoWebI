package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.RutinaSemanalVacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MisRutinasController {

    private ServicioRutina servicioRutina;
    private RepositorioRutina repositorioRutina;

    @Autowired
    public MisRutinasController(ServicioRutina servicioRutina, RepositorioRutina repositorioRutina){
        this.servicioRutina = servicioRutina;
        this.repositorioRutina = repositorioRutina;
    }

    @RequestMapping("/misRutinas")
    public ModelAndView verMisRutinas(HttpServletRequest request) throws RutinaSemanalVacia {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("Email") != null) {
            ModelMap modelo = new ModelMap();
//            modelo.put("rutinaSemanal", new RutinaSemanal());
            List<RutinaSemanal> rutinaSemanal = servicioRutina.obtenerTodasLasRutinasById((Long)session.getAttribute("id"));
            modelo.put("Email", session.getAttribute("Email"));
            return new ModelAndView("misRutinas", modelo);
        } else {
            return new ModelAndView("redirect:/login");

        }
    }

    @Transactional
    @RequestMapping(path = "/actualizarRutina", method = RequestMethod.POST)
    public ModelAndView actualizarRutina(@RequestBody RutinaSemanal rutinaSemanal, HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        // Actualiza las rutinas en la base de datos
        servicioRutina.actualizarRutina(rutinaSemanal);
        return actualizacionExitosa(modelo);
    }

    protected ModelAndView actualizacionExitosa(ModelMap model) {
        model.put("confirmacion","La rutina ha sido actualizada exitosamente");
        return new ModelAndView("redirect:/misRutinas",model);
    }
}
