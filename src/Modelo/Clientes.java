/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author ESTACION
 */
public class Clientes implements Serializable {

    private int identificacion;
    private String nombre_empresa;
    private String nombre_contacto;
    private String direccion;
    private String correo;
    private String URL;
    private int telefono;
    private String ciudad;
    
    public Clientes(){}

    public Clientes(int identificacion, String nombre_empresa, String nombre_contacto, String direccion, String correo, String URL, int telefono, String ciudad) {
        this.identificacion = identificacion;
        this.nombre_empresa = nombre_empresa;
        this.nombre_contacto = nombre_contacto;
        this.direccion = direccion;
        this.correo = correo;
        this.URL = URL;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
