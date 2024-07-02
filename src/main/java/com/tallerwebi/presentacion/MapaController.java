package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    public MapaController(ServicioMapa servicioSearch, ServicioMembresia servicioMembresia, ServicioUsuario servicioUsuario) {
        this.servicioSearch = servicioSearch;
        this.servicioUsuario = servicioUsuario;
        this.servicioMembresia = servicioMembresia;

    }

    @Transactional
    @GetMapping("/mapaBuscador")
    public ModelAndView irASearch(@RequestParam(value = "tipoActividad", required = false) String tipoActividad,
                                  @RequestParam(value = "distancia", required = false) Integer distancia,
                                  HttpServletRequest request) {
        List<Lugar> lugares;
        HttpSession session = request.getSession(false);
        ModelMap modelo = new ModelMap();
<<<<<<< HEAD
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
=======
        double latitudUsuario;
        double longitudUsuario;
>>>>>>> 562f158ef23f64da2cfb79c380ee10827c3bfc40

        try {
            if (session != null && session.getAttribute("Email") != null) {
                modelo.put("Email", session.getAttribute("Email"));
                modelo.put("id", session.getAttribute("id"));
                Usuario usuario = servicioUsuario.buscarPorId((Long) session.getAttribute("id"));

                modelo.put("usuario", usuario);
                latitudUsuario = usuario.getLatitud();
                longitudUsuario = usuario.getLongitud();
                modelo.put("latitudUsuario", latitudUsuario);
                modelo.put("longitudUsuario", longitudUsuario);

                // Manejo de membresías comentado
                /*
                Membresia membresia = servicioMembresia.membresiasPorId(usuario.getId());
                if (membresia == null || "GRATUITO".equals(membresia.getTipo())) {
                    modelo.put("error", "No tienes acceso a esta sección. Actualice su Membresia");
                    return new ModelAndView("datos", modelo);
                }
                */
            } else {
                latitudUsuario = -34.74973643128108;
                longitudUsuario = -58.571734784656066;
                modelo.put("latitudUsuario", latitudUsuario);
                modelo.put("longitudUsuario", longitudUsuario);
            }

            if (tipoActividad == null || tipoActividad.isEmpty()) {
                lugares = servicioSearch.buscarSitios();
            } else {
                Long idActividad = Long.parseLong(tipoActividad);
                lugares = servicioSearch.buscarLugaresPorTipoActividad(idActividad);
            }

            if (distancia != null) {
                lugares = servicioSearch.filtrarLugaresPorDistancia(lugares, latitudUsuario, longitudUsuario, distancia);
            }

            if (lugares.isEmpty()) {
                modelo.put("error", "No se encontraron lugares para los filtros seleccionados.");
            }
            modelo.put("lugares", lugares);

        } catch (SearchException e) {
            modelo.put("error", "Error al buscar lugares: " + e.getMessage());
        }

        return new ModelAndView("mapaBuscador", modelo);
    }

    @Transactional
    @PostMapping("/actualizarUbicacion")
    @ResponseBody
    public String actualizarUbicacion(@RequestParam("latitud") double latitud,
                                      @RequestParam("longitud") double longitud,
                                      HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("id") != null) {
            Long userId = (Long) session.getAttribute("id");
            Usuario usuario = servicioUsuario.buscarPorId(userId);

            if (usuario != null) {
                usuario.setLatitud(latitud);
                usuario.setLongitud(longitud);
                servicioUsuario.updateData(usuario);
                return "Ubicación actualizada correctamente.";
            }
        }

        return "No se pudo actualizar la ubicación.";
    }

    //return new ModelAndView("redirect:/home", modelo);
}


