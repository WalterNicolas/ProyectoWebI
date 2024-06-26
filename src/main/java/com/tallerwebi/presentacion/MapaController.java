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
                                  HttpServletRequest request) throws SearchException {
        List<Lugar> lugares;
        HttpSession session = request.getSession(false);
        ModelMap modelo = new ModelMap();

        if (session != null && session.getAttribute("Email") != null) {
            modelo.put("Email", session.getAttribute("Email"));
            modelo.put("id", session.getAttribute("id"));
            Usuario usuario = servicioUsuario.buscarPorId((Long) session.getAttribute("id"));

            modelo.put("usuario", usuario);
            // Obtener coordenadas del usuario
            double latitud = usuario.getLatitud(); // Asumiendo que el usuario tiene estas propiedades
            double longitud = usuario.getLongitud();

            modelo.put("latitudUsuario", latitud);
            modelo.put("longitudUsuario", longitud);

            // Lógica de membresía comentada previamente
        /*Membresia membresia = servicioMembresia.membresiasPorId(usuario.getId());
        if (membresia == null || "GRATUITO".equals(membresia.getTipo())) {
            modelo.put("error", "No tienes acceso a esta sección. Actualice su Membresia");
            return new ModelAndView("datos", modelo);
        }*/
        } else {
            // Definir una ubicación por defecto en caso de que no haya usuario logueado
            modelo.put("latitudUsuario", -34.74973643128108);
            modelo.put("longitudUsuario", -58.571734784656066);
        }

        if (tipoActividad == null || tipoActividad.isEmpty()) {
            lugares = servicioSearch.buscarSitios();
        } else {
            Long idActividad = Long.parseLong(tipoActividad);
            lugares = servicioSearch.buscarLugaresPorTipoActividad(idActividad);
        }

        modelo.addAttribute("lugares", lugares);
        return new ModelAndView("mapaBuscador", modelo);
    }

    @PostMapping("/actualizarUbicacion")
    @ResponseBody
    public ModelAndView actualizarUbicacion(@RequestParam("latitud") double latitud,
                                            @RequestParam("longitud") double longitud,
                                            HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        ModelMap modelo = new ModelMap();

        if (session != null && session.getAttribute("id") != null) {
            Long usuarioId = (Long) session.getAttribute("id");
            Usuario usuario = servicioUsuario.buscarPorId(usuarioId);

            if (usuario != null) {
                usuario.setLatitud(latitud);
                usuario.setLongitud(longitud);
                servicioUsuario.updateData(usuario); // Asume que tienes un método para actualizar el usuario
                modelo.put("usuario", usuario);
                modelo.put("mensaje", "Ubicación actualizada exitosamente.");
            } else {
                modelo.put("error", "Usuario no encontrado.");
            }
        } else {
            modelo.put("error", "No hay sesión activa.");
        }

        return new ModelAndView("mapaBuscador", modelo);
    }

    //return new ModelAndView("redirect:/home", modelo);
}


