package com.tallerwebi.dominio;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String ubicacion;
    private Double longitud;
    private Double latitud;
    @Transient
    private String distancia;  // No persistir la distancia calculada, es una propiedad derivada

    @ManyToMany
    @JoinTable(
            name = "Lugar_TipoEntrenamiento",
            joinColumns = @JoinColumn(name = "lugar_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoEntrenamiento_id")
    )
    private Set<TipoEntrenamiento> tiposEntrenamiento = new HashSet<>();

    public Lugar(String nombre, String ubicacion, Double longitud, Double latitud) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    public String calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = 6371 * c;  // Distancia en kilómetros

        return Math.round(distancia * 100.0) / 100.0 + " km";
    }

}
