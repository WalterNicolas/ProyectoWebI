package com.tallerwebi.dominio;

import com.tallerwebi.dominio.enums.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.List;

@Data
@NoArgsConstructor
public class Lugar {

    private String nombre;
    private List<ExerciseType> type;
    private String ubicacion;
    private Double longitud;
    private Double latitud;
    private String distancia;

    public final double RADIUS_OF_EARTH_KM = 6371;

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioSearch servicioSearch;

    public Lugar(String nombre, List<ExerciseType> type, String ubicacion, Double longitud, Double latitud) {
        this.nombre = nombre;
        this.type = type;
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
