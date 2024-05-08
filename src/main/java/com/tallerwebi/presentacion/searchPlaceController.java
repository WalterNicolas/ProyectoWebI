package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.ServicioSearch;
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
        List<Lugar> lugares = null;
        try {
            lugares = servicioSearch.buscarSitios();
            ModelMap modelo = new ModelMap();
            modelo.addAttribute("lugares", lugares);
            return new ModelAndView("search_place", modelo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
