package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPerfil {


        private ServicioLogin servicioLogin;


       /* @Autowired
        public ControladorPerfil(ServicioLogin servicioLogin){
            this.servicioLogin = servicioLogin;
        }*/


        @RequestMapping("/perfil")
        public ModelAndView irALogin() {
            Usuario usuario = new Usuario ();

            ModelMap modelo = new ModelMap();
            modelo.put("user",usuario);
            return new ModelAndView("perfil", modelo);
        }


}