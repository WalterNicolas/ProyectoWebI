package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
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
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MapaController {

    private ServicioMapa servicioSearch;
    private ServicioMembresia servicioMembresia;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public MapaController(ServicioMapa servicioSearch, ServicioMembresia servicioMembresia, ServicioUsuario servicioUsuario){
        this.servicioSearch = servicioSearch;
        this.servicioUsuario = servicioUsuario;
        this.servicioMembresia = servicioMembresia;
    }
    @Transactional
    @GetMapping("/mapaBuscador")
    public ModelAndView irASearch(@RequestParam(value = "query", required = false) String query, HttpServletRequest request) {
        List<Lugar> lugares;
        HttpSession session = request.getSession(false);
        ModelMap modelo = new ModelMap();
        if (session != null && session.getAttribute("Email") != null) {
            modelo.put("Email", session.getAttribute("Email"));
            modelo.put("id", session.getAttribute("id"));
            Usuario usuario = servicioUsuario.buscarPorId((Long) session.getAttribute("id"));
            Membresia membresia = servicioMembresia.membresiasPorId(usuario.getId());
            if (membresia == null || "GRATUITO".equals(membresia.getTipo())) {
                modelo.put("error", "No tienes acceso a esta sección. Actualice su Membresia");
                return new ModelAndView("datos", modelo);
            }
            if (membresia != null && membresia.getFechaFin().isBefore(LocalDate.now())) {
                modelo.put("error", "Su membresía ha finalizado. Actualice su Membresía");
                return new ModelAndView("datos", modelo);
            }
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
        return new ModelAndView("redirect:/home", modelo);
    }

}
