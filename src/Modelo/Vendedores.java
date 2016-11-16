/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author daybe
 */
public class Vendedores implements Serializable {

    private int  Identificacion;
    private String nombre;
    private String Ciudades;
    private String Correo;

    public Vendedores() {
    }

    
    public Vendedores(int Identificacion, String nombre, String Ciudades, String Correo) {
        this.Identificacion = Identificacion;
        this.nombre = nombre;
        this.Ciudades = Ciudades;
        this.Correo = Correo;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudades() {
        return Ciudades;
    }

    public void setCiudades(String Ciudades) {
        this.Ciudades = Ciudades;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
