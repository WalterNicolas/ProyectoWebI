package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.ServicioSearch;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class searchPlaceController {

    private ServicioSearch servicioSearch;


    @Autowired
    public searchPlaceController(ServicioSearch servicioSearch){
        this.servicioSearch = servicioSearch;
    }

    @RequestMapping("/search")
    public ModelAndView irASearch() {
        List<Lugar> lugares;
        ModelMap modelo = new ModelMap();
        try {
            lugares = servicioSearch.buscarSitios();
            modelo.addAttribute("lugares", lugares);
            return new ModelAndView("search_place", modelo);
        } catch (SearchException e) {
            modelo.put("error","No hay lugares disponibles");
            return new ModelAndView("search_place", modelo);
        }
    }
}
