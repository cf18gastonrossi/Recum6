package com.example.recum6.model;

public class Hotel {

    private String nombre, cif;

    public Hotel(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static boolean checkInput(String nombre, String cif) {
        if (nombre.equalsIgnoreCase("")||cif.equalsIgnoreCase("")) {
            return false;
        }
        else {
            return true;
        }
    }
}
