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
    @Autowired
    private ServicioLogin servicioLogin;
    @Autowired
    private ServicioMembresia servicioMembresia;
    @Autowired
    private ServicioRutina servicioRutina;
    @Transactional
    @RequestMapping(path = "/asignarMembresia", method = RequestMethod.POST)
    public ModelAndView asignarMembresia(@RequestParam String tipo,  @RequestParam String email,@RequestParam int duracion,HttpServletRequest request) throws UsuarioInexistenteException {
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
            membresia.setUsuario(usuario);
            servicioMembresia.crearMembresia(membresia);
            // Inmediatamentee que se Genera un Membresia se ve reflejada la rutina que fue generada con las aptitudes que puso en AptitudesFisicas
           RutinaSemanal rutinaSemanal = servicioRutina.generarRutinaSemanal(usuario);

           System.out.print(rutinaSemanal.getRutinasDiarias());
           modelo.put("Email", session.getAttribute("Email"));
           modelo.put("membresia",membresia);
           modelo.put("usuario",usuario);
           modelo.put("rutinaSemanal", rutinaSemanal);
            return new ModelAndView("home",modelo);
        } catch (UsuarioInexistenteException ex) {
            modelo.put("error", ex.getMessage());
            return new ModelAndView("home", modelo);
        }
    }
}
