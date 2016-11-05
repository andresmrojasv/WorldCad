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
    private String nombre;
    private String direccion;
    private String correo;
    private String URL;
    private int telefono;
    private String ciudad;
    
    public Clientes(){}

    public Clientes(int identificacion, String nombre, String direccion, String correo, String URL, int telefono, String ciudad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
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
