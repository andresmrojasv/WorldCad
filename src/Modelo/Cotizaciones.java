/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo_Garcia
 */
public class Cotizaciones implements Serializable {
    
    private String cliente, vendedor, descripcion, fechaEstCierre, fechaCierre,NumCotizacion;
    private double porcentajecierre;
    DetalleCotizacion detallecotiza; 

    public Cotizaciones() {
    }

    public Cotizaciones(String cliente, String vendedor, String descripcion, String fechaEstCierre,  double porcentajecierre) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.descripcion = descripcion;
        this.fechaEstCierre = fechaEstCierre;
        this.porcentajecierre = porcentajecierre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEstCierre() {
        return fechaEstCierre;
    }

    public void setFechaEstCierre(String fechaEstCierre) {
        this.fechaEstCierre = fechaEstCierre;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getNumCotizacion() {
        return NumCotizacion;
    }

    public void setNumCotizacion(String NumCotizacion) {
        this.NumCotizacion = NumCotizacion;
    }

    public double getPorcentajecierre() {
        return porcentajecierre;
    }

    public void setPorcentajecierre(double porcentajecierre) {
        this.porcentajecierre = porcentajecierre;
    }

    public DetalleCotizacion getDetallecotiza() {
        return detallecotiza;
    }

    public void setDetallecotiza(DetalleCotizacion detallecotiza) {
        this.detallecotiza = detallecotiza;
    }

    
}
