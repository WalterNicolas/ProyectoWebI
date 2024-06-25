package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.NoHayArticulosDeEseTipo;
import com.tallerwebi.dominio.excepcion.NoHayInformacionDelArticulo;
import com.tallerwebi.dominio.excepcion.UsuarioInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ControladorTipsYNutricion {
    @Autowired
    ServicioLogin servicioLogin;
    @Autowired
    ServicioTipsYNutricion servicioTipsYNutricion;

    @Autowired
    public ControladorTipsYNutricion(ServicioLogin servicioLogin, ServicioTipsYNutricion servicioTipsYNutricion) {
        this.servicioLogin = servicioLogin;
        this.servicioTipsYNutricion = servicioTipsYNutricion;
    }

    @RequestMapping("/tipsYNutricion")

    public ModelAndView vistaTipsYNutricion(HttpServletRequest request) throws UsuarioInexistenteException ,NoHayArticulosDeEseTipo {
        HttpSession session = request.getSession(false);
        ModelMap modelo = new ModelMap();
        String mailLogeado = (String) session.getAttribute("Email");
        if (session != null && mailLogeado != null) {
            try {
                Usuario usuario = servicioLogin.buscarPorMail(mailLogeado);
                List<TipoEntrenamiento> tiposEntrenamiento = usuario.getAptitudFisica().getTiposEntrenamiento();
                List<Articulo> listaArticulos = servicioTipsYNutricion.buscarTipsPorTipoDeEntrenamiento(tiposEntrenamiento.iterator().next().getDescripcion());
                modelo.put("articulos", listaArticulos);
                modelo.put("tipoEntrenamiento",usuario.getAptitudFisica().getTiposEntrenamiento() );
            } catch (NoHayArticulosDeEseTipo e) {
                modelo.put("error", "No hay articulos");
                return new ModelAndView("tipsYNutricion", modelo);
            }
        } else {
            return new ModelAndView("redirect:/login");
        }
        modelo.put("Email", mailLogeado);
        return new ModelAndView("tipsYNutricion", modelo);
    }
    @RequestMapping("/tipsYNutricion/{id}")
    @ResponseBody
    public Articulo  obtenerDetalleArticulo(@PathVariable Long id) throws NoHayInformacionDelArticulo {
        System.out.println(id);
        Articulo articulo = servicioTipsYNutricion.getArticuloPorId(id);
        if (articulo != null) {
            return articulo;
        } else {
            return null;
        }
    }
}
