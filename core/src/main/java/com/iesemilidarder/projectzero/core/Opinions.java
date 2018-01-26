package com.iesemilidarder.projectzero.core;

/**
 * zero-project
 * com.iesemilidarder.projectzero.core
 * Created by ${User} in 26/1/2018
 * Description:
 **/
/*
Creamos la clase Opinions con los string privadas y sus getters y setters
*/

public class Opinions {
    private String observacion;
    private String puntuacion;
    private String usuario;


    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
