package com.iesemilidarder.projectzero.core;

import java.util.ArrayList;

/*
Creamos la clase restaurants con los string privadas y sus getters y setters
*/
/*
Creamos la clase restaurants con los string privadas y sus getters y setters ademas creamos un array list de opiniones y una clase publica de restaurantes para la array list
*/
public class Restaurantes {
    private String codigo;
    private String nombre;
    private String direccion;
    private String web;
    private String telefono;
    private String descripcion;
    private String imagen;
    private String mitjana;
    private String latitud;
    private String longitud;
    private ArrayList<Opinions> opiniones;

    public Restaurantes() {this.opiniones = new ArrayList<Opinions>();}

    public ArrayList<Opinions> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(ArrayList<Opinions> opiniones) {
        this.opiniones = opiniones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMitjana() {
        return mitjana;
    }

    public void setMitjana(String mitjana) {
        this.mitjana = mitjana;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
/*
Tomás Sastre Cámara
2n ASIX
WAI
*/
