package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Lugar;
import com.tallerwebi.dominio.ServicioMapa;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/mapaBuscador")
    public ModelAndView irASearch(@RequestParam(value = "query", required = false) String query) {
        List<Lugar> lugares;
        ModelMap modelo = new ModelMap();
        try {
            if (query == null || query.isEmpty()) {
                lugares = servicioSearch.buscarSitios();
            } else {
                lugares = servicioSearch.buscarLugaresPorNombre(query);
            }
            modelo.addAttribute("lugares", lugares);
            return new ModelAndView("mapaBuscador", modelo);
        } catch (SearchException e) {
            modelo.put("error", "No hay lugares disponibles");
            return new ModelAndView("mapaBuscador", modelo);
        }
    }

   /* @RequestMapping("/mapaBuscador")
    public ModelAndView irASearch() {
>>>>>>> e9957f37a788e5c0b2f28b5d55086884155c7558
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
    }*/
}
