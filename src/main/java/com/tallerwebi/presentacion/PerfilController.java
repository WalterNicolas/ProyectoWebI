package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.presentacion.DataModel.AptitudFisica;
import com.tallerwebi.presentacion.DataModel.DetalleRutina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PerfilController {

    @RequestMapping("/perfil")
    public static ModelAndView irAPerfil() {
        ModelMap modelo = new ModelMap();
        modelo.put("usuario",new Usuario());
        modelo.put("aptitudFisica", new AptitudFisica());
        return new ModelAndView("perfil", modelo);
    }
}
