package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioRoutines;
import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyRoutinesController  {

    ServicioRoutines servicioRoutines = new ServicioRoutinesImp();

    @Autowired
    public MyRoutinesController(ServicioRoutines servicioRoutines) {
        this.servicioRoutines = servicioRoutines;
    }

    @RequestMapping("/routines-summary")
    public ModelAndView verMisRutinas() {
        ModelMap modelo = new ModelMap();
        modelo.put("detalleRutina", new DetalleRutina());
        return new ModelAndView("my-routines", modelo);
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
