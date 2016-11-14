/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pablo_Garcia
 */
public class DetalleCotizacion {
    private double precioVenta, precioTotal, subTotal,iva, total;
    private int cantidad;
    private String producto,numParte;

    public DetalleCotizacion() {
    }

    public DetalleCotizacion(double precioVenta, double precioTotal, double subTotal, double iva, double total, int cantidad, String producto, String numParte) {
        this.precioVenta = precioVenta;
        this.precioTotal = precioTotal;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
        this.cantidad = cantidad;
        this.producto = producto;
        this.numParte = numParte;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNumParte() {
        return numParte;
    }

    public void setNumParte(String numParte) {
        this.numParte = numParte;
    }

    
}
