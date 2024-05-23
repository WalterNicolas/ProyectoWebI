package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.AptitudFisica;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PerfilController {

    @RequestMapping("/perfil")
    public  ModelAndView irAPerfil(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("Email") != null) {
            ModelMap modelo = new ModelMap();
            modelo.put("usuario", new Usuario());
            modelo.put("Email", session.getAttribute("Email"));
            modelo.put("aptitudFisica", new AptitudFisica());
            return new ModelAndView("perfil", modelo);
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
}
