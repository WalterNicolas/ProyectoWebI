package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioMapa;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MapaController {

    private ServicioMapa servicioSearch;


    @Autowired
    public MapaController(ServicioMapa servicioSearch){
        this.servicioSearch = servicioSearch;
    }

    @RequestMapping("/mapaBuscador")
    public ModelAndView irASearch(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<Lugar> lugares;
        ModelMap modelo = new ModelMap();
        try {
            if (session != null && session.getAttribute("Email") != null) {
                lugares = servicioSearch.buscarSitios();
                modelo.addAttribute("lugares", lugares);
                return new ModelAndView("mapaBuscador", modelo);
            }else{
                return new ModelAndView("redirect:/login");
            }
        } catch (SearchException e) {
            modelo.put("error","No hay lugares disponibles");
            return new ModelAndView("mapaBuscador", modelo);
        }
    }
}
