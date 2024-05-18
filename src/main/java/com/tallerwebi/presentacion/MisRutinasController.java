package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioRutina;
import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MisRutinasController {

    private ServicioRutina servicioRutina;

    @Autowired
    public MisRutinasController(ServicioRutina servicioRutina) {
        this.servicioRutina = servicioRutina;
    }

    @RequestMapping("/misRutinas")
    public static ModelAndView verMisRutinas() {
        ModelMap modelo = new ModelMap();
        modelo.put("detalleRutina", new DetalleRutina());
        return new ModelAndView("misRutinas", modelo);
    }

//    @RequestMapping("/routines-update", method = RequestMethod.POST)
//    public ModelAndView actualizarMisRutinas() {
//        ModelMap modelo = new ModelMap();
//        modelo.put("detalleRutina", new DetalleRutina());
//        return new ModelAndView("redirect:/routines-summary", modelo);
//    }
//
//    @RequestMapping(path = "/routines-summary", method = RequestMethod.GET)
//    public ModelAndView volverAMisRutinas(ModelMap modelo) {
//        return new ModelAndView("redirect:/routines-summary");
//    }
}
