package com.example.recum6.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotel")
public class Hotel {

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "cif")
    private String cif;

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
        if (nombre.equalsIgnoreCase("") || cif.equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }
}
