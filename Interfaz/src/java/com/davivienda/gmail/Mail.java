/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davivienda.gmail;

import com.utilidades.Mails;
import java.io.Serializable;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wilso
 */
public class Mail implements Serializable {
    
    private String usuario;
    private String clave;
    private String motivo;
    private String destinario;
    private String mensaje;
    private String resultado;
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public void enviar(ActionEvent e) {
        Mails mails = new Mails();
        mails.setUsuario(usuario);
        mails.setClave(clave);
        mails.setOrigen(usuario);
        mails.setMotivo(motivo);
        mails.setDestino(destinario);
        mails.setMensaje(mensaje);
        mails.enviar();
        if (mails.isEstado()) {
            resultado = "Mensaje enviado exitosamente";
        } else {
            resultado = "Mensaje no enviado";
        }
        
    }
    
    public void cancelar(ActionEvent e) {
        
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public String getDestinario() {
        return destinario;
    }
    
    public void setDestinario(String destinario) {
        this.destinario = destinario;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Mail() {
    }
    
}
