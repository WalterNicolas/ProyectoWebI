package com.tallerwebi.dominio;

import com.tallerwebi.dominio.enums.ExerciseType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Lugar {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nombre;

    //private List<ExerciseType> type;
    private String ubicacion;
    private Double longitud;
    private Double latitud;
    private String distancia;

    @Nullable
    public final double RADIUS_OF_EARTH_KM = 6371;

    // @Autowired
    //private ServicioUsuario servicioUsuario;

    //@Autowired
    //private ServicioMapa servicioSearch;

    public Lugar(String nombre, String ubicacion, Double longitud, Double latitud) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.distancia = calculateDistance(longitud,latitud);
    }

    public String calculateDistance(double lat1, double lon1) {

        Double userLatitud = -34.74973643128108;
        Double userLongitud = -58.571734784656066;

        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(userLatitud);
        double lon2Rad = Math.toRadians(userLongitud);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = RADIUS_OF_EARTH_KM * c;

        double roundedDistance = Math.round(distancia * 100.0) / 100.0;
        this.distancia =  roundedDistance + " km";

        return this.distancia;
    }

}
