package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorDatos {

    private final ServicioUsuario servicioUsuario;
    private final ServicioPeso servicioPeso;

    private final ServicioMembresia servicioMembresia;

    @Autowired
    public ControladorDatos(ServicioUsuario servicioUsuario,ServicioPeso servicioPeso, ServicioMembresia servicioMembresia){
        this.servicioUsuario = servicioUsuario;
        this.servicioPeso = servicioPeso;
        this.servicioMembresia = servicioMembresia;
    }

    @Transactional
    @RequestMapping("/datos")
    public ModelAndView MostrarDatos(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        ModelMap modelo = new ModelMap();

        if (session != null && session.getAttribute("Email") != null){
            modelo.put("Email",session.getAttribute("Email") );
            modelo.put("id",session.getAttribute("id") );
            Usuario usuario = servicioUsuario.buscarPorId((Long)session.getAttribute("id"));
            ArrayList pesosRegistro = servicioPeso.obtenerPesosPorMes(usuario.getId());
            Membresia membresia = servicioMembresia.membresiasPorId(usuario.getId()).get(0);
            modelo.put("registroPeso",pesosRegistro);
            modelo.put("usuario",usuario);
            modelo.put("membresia",membresia);
            modelo.put("datosPeso", new DatosPeso());
            return new ModelAndView("datos", modelo);
        }

        return null;
    }

    @Transactional
    @RequestMapping("/cargar-peso")
    public ModelAndView PostPeso(@ModelAttribute("datosPeso") DatosPeso datosPeso,HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("Email") != null){
            modelo.put("id",session.getAttribute("id") );
            Usuario usuario = servicioUsuario.buscarPorId((Long)session.getAttribute("id"));
            servicioPeso.postPeso(usuario,datosPeso);
            return new ModelAndView("redirect:/datos", modelo);
        }
        return null;
    }


}
