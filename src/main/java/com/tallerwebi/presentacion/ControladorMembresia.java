package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.UsuarioInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Controller
public class ControladorMembresia {

    private ServicioLogin servicioLogin;

    private ServicioMembresia servicioMembresia;

    private ServicioRutina servicioRutina;
    @Autowired
    public ControladorMembresia(ServicioLogin servicioLogin, ServicioMembresia servicioMembresia,ServicioRutina servicioRutina){
        this.servicioLogin = servicioLogin;
        this.servicioMembresia = servicioMembresia;
        this.servicioRutina = servicioRutina;
    }
    @Transactional
    @RequestMapping(path = "/asignarMembresia", method = RequestMethod.POST)
    public ModelAndView asignarMembresia(@RequestParam String tipo, @RequestParam String email, @RequestParam int duracion, HttpServletRequest request) throws UsuarioInexistenteException {
        ModelMap modelo = new ModelMap();
        try {
            HttpSession session = request.getSession(false);
            Usuario usuario = servicioLogin.buscarPorMail(email);
            Membresia membresia = new Membresia();
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaFutura = fechaActual.plusMonths(duracion);

            membresia.setFechaFin(fechaFutura);
            membresia.setFechaInicio(fechaActual);
            membresia.setDuracion(duracion);
            membresia.setTipo(tipo);
            // membresia.setUsuario(usuario);
            servicioMembresia.crearMembresia(membresia);

            // Se genera la rutina a partir de la Aptitud Fisica del Usuario
            RutinaSemanal rutinaSemanal = servicioRutina.generarRutinaSemanal(usuario);

            System.out.println(membresia);
            session.setAttribute("Email", email);
            session.setAttribute("membresia", membresia);
            session.setAttribute("usuario", usuario);
            session.setAttribute("rutinaSemanal", rutinaSemanal);

            return new ModelAndView("redirect:/home");
        } catch (UsuarioInexistenteException ex) {
            modelo.put("error", "Usuario no encontrado");
            return new ModelAndView("home", modelo);
        }
    }

}
