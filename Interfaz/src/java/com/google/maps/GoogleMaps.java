/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.maps;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import maps.java.Geocoding;

/**
 *
 * @author wilso
 */
public class GoogleMaps implements Serializable {

    private String ubicacion;
    private String resultadoEnX;
    private String resultadoEnY;
    private String busquedaGlobal;

    public String getBusquedaGlobal() {
        return busquedaGlobal;
    }

    public void setBusquedaGlobal(String busquedaGlobal) {
        this.busquedaGlobal = busquedaGlobal;
    }

    public String getResultadoEnX() {
        return resultadoEnX;
    }

    public void setResultadoEnX(String resultadoEnX) {
        this.resultadoEnX = resultadoEnX;
    }

    public String getResultadoEnY() {
        return resultadoEnY;
    }

    public void setResultadoEnY(String resultadoEnY) {
        this.resultadoEnY = resultadoEnY;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void consultar(ActionEvent e) {

        Geocoding ObjGeocod = new Geocoding();
        try {

            Point2D.Double resultadoCD = ObjGeocod.getCoordinates(ubicacion);
            resultadoEnX = String.valueOf(resultadoCD.x);
            resultadoEnY = String.valueOf(resultadoCD.y);
            ArrayList<String> resultadoCI = ObjGeocod.getAddress(resultadoCD.x, resultadoCD.y);
            for (String item : resultadoCI) {
                busquedaGlobal = item;
                break;
            }
        } catch (UnsupportedEncodingException | MalformedURLException ex) {

        }

    }

    public void cerrar(ActionEvent e) {
        this.ubicacion = "";
        this.resultadoEnX = "";
        this.resultadoEnY = "";
        this.busquedaGlobal = "";
    }

    public GoogleMaps() {
    }

}
