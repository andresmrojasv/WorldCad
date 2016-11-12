/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Pablo_Garcia
 */
public class Cotizaciones implements Serializable {
    
    private String cliente, vendedor, descripcion,fechaEstCierre, fechaCreacion, fechaCierre,numCotizacion;
    private int cantidad;
    private double porcentajeCierre,precioUnitario, precioTotal, subTotal,iva, total;

    public Cotizaciones() {
    }

    public Cotizaciones(String cliente, String vendedor, String descripcion, String fechaEstCierre, String fechaCreacion, String fechaCierre, String numCotizacion, int cantidad, double porcentajeCierre, double precioUnitario, double precioTotal, double subTotal, double iva, double total) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.descripcion = descripcion;
        this.fechaEstCierre = fechaEstCierre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.numCotizacion = numCotizacion;
        this.cantidad = cantidad;
        this.porcentajeCierre = porcentajeCierre;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(String numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPorcentajeCierre() {
        return porcentajeCierre;
    }

    public void setPorcentajeCierre(double porcentajeCierre) {
        this.porcentajeCierre = porcentajeCierre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }    
    
}
