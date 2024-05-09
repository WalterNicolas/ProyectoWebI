package com.tallerwebi.dominio;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Random;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;
    private String password;
    private String rol;
    private String nombre;
    private String apellido;
    private Boolean activo = false;
    private Double longitud;
    private Double latitud;
    private Double altura;
    private Double peso;
    private Date date;
    private Integer diasEntrenados;
    private Integer horasEntrenadas;

    public Usuario( ) {
        Random random = new Random();
        this.nombre=  "Juan";
        this.apellido = "Pedro";
        this.id = Math.abs(random.nextLong());
        this.longitud =  90.0; // Rango de -90 a 90
        this.latitud = 180.12; // Rango de -180 a 180
        this.altura = 162.3; // Rango de 0 a 300
        this.peso =  150.10; // Rango de 0 a 150
        this.diasEntrenados = 5; // Rango de 0 a 7
        this.horasEntrenadas = 3 ; // Rango de 0 a 24
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public boolean activo() {
        return activo;
    }

    public void activar() {
        activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
