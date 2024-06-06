package com.tallerwebi.dominio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPeso {
    void save(PesoRegistro pesoRegistro);

    List<PesoRegistro> findByUsuarioId(Long usuarioId);

}
