package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioBusqueda;
import com.tallerwebi.dominio.excepcion.BusquedaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ControladorLugarDeBusqueda {

    private ServicioBusqueda servicioSearch;


    @Autowired
    public ControladorLugarDeBusqueda(ServicioBusqueda servicioSearch){
        this.servicioSearch = servicioSearch;
    }

    @RequestMapping("/search")
    public ModelAndView irASearch() {
        List<Lugar> lugares;
        ModelMap modelo = new ModelMap();
        try {
            lugares = servicioSearch.buscarSitios();
            modelo.addAttribute("lugares", lugares);
            return new ModelAndView("lugar-de-busqueda", modelo);
        } catch (BusquedaException e) {
            modelo.put("error","No hay lugares disponibles");
            return new ModelAndView("lugar-de-busqueda", modelo);
        }
    }
}
