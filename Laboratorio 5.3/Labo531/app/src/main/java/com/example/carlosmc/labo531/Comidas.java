package com.example.carlosmc.labo531;


public class Comidas {

    private String nombre;
    private String descripcion;

    public Comidas(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
