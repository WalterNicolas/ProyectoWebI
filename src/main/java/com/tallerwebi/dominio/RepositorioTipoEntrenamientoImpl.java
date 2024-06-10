package com.tallerwebi.dominio;

import com.tallerwebi.dominio.AptitudFisica;
import com.tallerwebi.dominio.RepositorioTipoEntrenamiento;
import com.tallerwebi.dominio.TipoEntrenamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoEntrenamientoImpl implements RepositorioTipoEntrenamiento {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void guardar(AptitudFisica aptitudFisica) {
        String sql = "INSERT INTO AptitudFisica (altura, peso, fechaNacimiento, diasEntrenamiento, horasEntrenamiento, estadoFisico, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, aptitudFisica.getAltura(), aptitudFisica.getPeso(), aptitudFisica.getFechaNacimiento(), aptitudFisica.getDiasEntrenamiento(), aptitudFisica.getHorasEntrenamiento(), aptitudFisica.getEstadoFisico(), aptitudFisica.getUsuario().getId());
    }

    @Override
    public void guardarRelacion(Long aptitudFisicaId, Long tipoEntrenamientoId) {
        String sql = "INSERT INTO AptitudFisicaTipoEntrenamiento (aptitudFisica_id, tipoEntrenamiento_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, aptitudFisicaId, tipoEntrenamientoId);
    }

    @Override
    public TipoEntrenamiento findByNombre(String nombre) {
        String sql = "SELECT * FROM TipoEntrenamiento WHERE nombre = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nombre}, (rs, rowNum) ->
                new TipoEntrenamiento(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                )
        );
    }
}
