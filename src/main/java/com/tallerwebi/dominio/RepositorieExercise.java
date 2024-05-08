package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DataModel.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorieExercise extends JpaRepository<Exercise, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
}
