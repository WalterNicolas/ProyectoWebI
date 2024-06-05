package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Membresia;
import com.tallerwebi.dominio.RepositorioMembresia;
import com.tallerwebi.dominio.ServicioMembresia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioMembresiaImp implements ServicioMembresia {
    @Autowired
    RepositorioMembresia repositorioMembresia;

    public ServicioMembresiaImp (RepositorioMembresia repositorioMembresia){
        this.repositorioMembresia = repositorioMembresia;
    }
    @Override
    public Membresia membresiasPorId(Long usuarioId) {
        return repositorioMembresia.buscarPorUsuario(usuarioId);
    }

    @Override
    public void crearMembresia(Membresia membresia) {
        repositorioMembresia.crearMembresia(membresia);
    }

}
