package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarRepositorio extends JpaRepository<Lugar, Long> {
    List<Lugar> findByNombreContaining(String nombre);
}
