/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CotizacionesDAO;
import Modelo.Cotizaciones;
import Modelo.DetalleCotizacion;
import Modelo.Productos;
import Modelo.ProductosDAO;
import Vista.VistaCotizaciones;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo_Garcia
 */
public class ControladorCotizaciones implements ActionListener {

    private CotizacionesDAO modeloCotiza = new CotizacionesDAO();
    private ProductosDAO productosD;
    private VistaCotizaciones vistaC;
    private VistaMenu vistaM;
    private DefaultTableModel TablaProdcutos;
    ArrayList<DetalleCotizacion> detalleCotiza = new ArrayList();
    ArrayList<DetalleCotizacion> detallec = new ArrayList();
    private double subtotal = 0, iva = 0, total = 0;
    DecimalFormat decimales = new DecimalFormat("###.##");

    public ControladorCotizaciones(ProductosDAO productosD, VistaCotizaciones vistaC, VistaMenu vistaM) {
        this.productosD = productosD;
        this.vistaC = vistaC;
        this.vistaM = vistaM;
        this.TablaProdcutos = TablaProdcutos;
        this.vistaC.jBbuscarProducto.addActionListener(this);
        this.vistaC.jBagregarproducto.addActionListener(this);
        this.vistaC.jBCrearCotizacion.addActionListener(this);
        this.vistaC.jBModificar.addActionListener(this);
        this.vistaC.jBConsultar.addActionListener(this);
        this.vistaC.jBnuevaCotiza.addActionListener(this);
        this.vistaC.jBEliminar.addActionListener(this);
        this.vistaC.jBSalir.addActionListener(this);
        TablaProdcutos = (DefaultTableModel) this.vistaC.jTableDetalleProductos.getModel();

        this.vistaC.jBEliminar.setVisible(false);
        this.vistaC.jTproductoEliminar.setVisible(false);
        this.vistaC.jLproductoEliminar.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Nueva".equals(e.getActionCommand())) {

            this.vistaC.jTNumeroCotizacion.setEditable(false);
            this.vistaC.jTDescripcion.setEditable(true);
            this.vistaC.jTPorcentajeCierre.setEditable(true);
            this.vistaC.jFFestimadaCierre.setEditable(true);
            this.vistaC.jTBuscarProducto.setEditable(true);
            this.vistaC.jTcantidad.setEditable(true);
            this.vistaC.jTproductoEliminar.setEditable(true);

        }

        if (e.getActionCommand() == "Buscar Producto") {
            ArrayList<Productos> producto = productosD.consultarProducto(vistaC.jTBuscarProducto.getText());

            if (!producto.isEmpty()) {
                vistaC.jTnumParte.setText(producto.get(0).getNombreParte());
                vistaC.jTproducto.setText(producto.get(0).getNombreProducto());
                vistaC.jTprecioVenta.setText(String.valueOf(producto.get(0).getPrecioVenta()));

            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe\n");
            }
        }

        if (e.getActionCommand() == "Agregar") {

            DetalleCotizacion product = new DetalleCotizacion();
            product.setCantidad(Integer.parseInt(vistaC.jTcantidad.getText()));
            product.setNumParte(vistaC.jTnumParte.getText());
            product.setProducto(vistaC.jTproducto.getText());
            product.setPrecioVenta(Double.parseDouble(vistaC.jTprecioVenta.getText()));
            product.setPrecioTotal(Double.parseDouble(vistaC.jTcantidad.getText()) * Double.parseDouble(vistaC.jTprecioVenta.getText()));
            detalleCotiza.add(product);
            for (int i = 0; i < TablaProdcutos.getRowCount(); i++) {

                TablaProdcutos.removeRow(i);

            }

            for (DetalleCotizacion detalle : detalleCotiza) {
                Object[] fila = {detalle.getCantidad(), detalle.getNumParte(), detalle.getProducto(), detalle.getPrecioVenta(), detalle.getPrecioTotal()};
                TablaProdcutos.addRow(fila);

            }
            subtotal = 0;
            for (DetalleCotizacion detalle : detalleCotiza) {

                subtotal = subtotal + detalle.getPrecioTotal();

            }
            this.vistaC.jTSubTotal.setText(String.valueOf(decimales.format(subtotal)));
            this.vistaC.jTiva.setText(String.valueOf(decimales.format(iva = subtotal * 0.16)));
            this.vistaC.jTTotal.setText(String.valueOf(decimales.format(total = subtotal + iva)));
            vistaC.jTnumParte.setText(null);
            vistaC.jTcantidad.setText(null);
            vistaC.jTproducto.setText(null);
            vistaC.jTprecioVenta.setText(null);
            vistaC.jTBuscarProducto.setText(null);

        }
        if (e.getActionCommand() == "Crear") {
            SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
            String cliente = (String) (this.vistaC.jCCliente.getSelectedItem());
            String vendedor = (String) (this.vistaC.jCVendedor.getSelectedItem());
            String descripcion = this.vistaC.jTDescripcion.getText();
            String fechaECierre = this.vistaC.jFFestimadaCierre.getText();
            double porcentajeCierre = Double.parseDouble(this.vistaC.jTPorcentajeCierre.getText());

            this.modeloCotiza.registrarCotizacion(new Cotizaciones(cliente, vendedor, descripcion, fechaECierre, porcentajeCierre), detalleCotiza, subtotal, iva, total);
            vistaC.jTSubTotal.setText(null);
            vistaC.jTiva.setText(null);
            vistaC.jTTotal.setText(null);
            vistaC.jTPorcentajeCierre.setText(null);
            vistaC.jFFestimadaCierre.setText(null);
            vistaC.jTDescripcion.setText(null);
            int totalrow = TablaProdcutos.getRowCount();
            for (int i = 0; i < totalrow; i++) {

                TablaProdcutos.removeRow(0);

            }

            this.vistaC.jTNumeroCotizacion.setEditable(true);
            this.vistaC.jTDescripcion.setEditable(false);
            this.vistaC.jTPorcentajeCierre.setEditable(false);
            this.vistaC.jFFestimadaCierre.setEditable(false);
            this.vistaC.jTBuscarProducto.setEditable(false);
            this.vistaC.jTcantidad.setEditable(false);
            this.vistaC.jTproductoEliminar.setEditable(false);

        }
        if (e.getActionCommand() == "Modificar") {
            String numcotiza = this.vistaC.jTNumeroCotizacion.getText();
            String cliente = (String) (this.vistaC.jCCliente.getSelectedItem());
            String vendedor = (String) (this.vistaC.jCVendedor.getSelectedItem());
            String descripcion = this.vistaC.jTDescripcion.getText();
            String fechaECierre = this.vistaC.jFFestimadaCierre.getText();
            System.out.println("" + vistaC.jFFestimadaCierre.getText());
            double porcentajeCierre = Double.parseDouble(this.vistaC.jTPorcentajeCierre.getText());

            double subtotal = Double.parseDouble(this.vistaC.jTSubTotal.getText());
            double iva = Double.parseDouble(this.vistaC.jTiva.getText());
            double total = Double.parseDouble(this.vistaC.jTTotal.getText());

            this.modeloCotiza.modificarCotizacion(new Cotizaciones(cliente, vendedor, descripcion, fechaECierre, porcentajeCierre), detalleCotiza, subtotal, iva, total, numcotiza);

            vistaC.jTSubTotal.setText(null);
            vistaC.jTiva.setText(null);
            vistaC.jTTotal.setText(null);
            vistaC.jTPorcentajeCierre.setText(null);
            vistaC.jFFestimadaCierre.setText(null);
            vistaC.jTDescripcion.setText(null);
            int totalrow = TablaProdcutos.getRowCount();
            for (int i = 0; i < totalrow; i++) {

                TablaProdcutos.removeRow(0);

            }

            this.vistaC.jTNumeroCotizacion.setEditable(true);
            this.vistaC.jTDescripcion.setEditable(false);
            this.vistaC.jTPorcentajeCierre.setEditable(false);
            this.vistaC.jFFestimadaCierre.setEditable(false);
            this.vistaC.jTBuscarProducto.setEditable(false);
            this.vistaC.jTcantidad.setEditable(false);
            this.vistaC.jTproductoEliminar.setEditable(false);

        }
        if (e.getActionCommand() == "Consultar") {
            ArrayList<Cotizaciones> DatosCotizacion = modeloCotiza.consultarCotizacion(vistaC.jTNumeroCotizacion.getText());

            //detallec= modeloCotiza.consultarDetalleCotizacion(vistaC.jTNumeroCotizacion.getText());
            detalleCotiza = modeloCotiza.consultarDetalleCotizacion(vistaC.jTNumeroCotizacion.getText());

            this.vistaC.jTNumeroCotizacion.setEditable(true);
            if (!DatosCotizacion.isEmpty()) {
                this.vistaC.jCCliente.setSelectedItem(DatosCotizacion.get(0).getCliente());
                this.vistaC.jCVendedor.setSelectedItem(DatosCotizacion.get(0).getVendedor());
                this.vistaC.jTDescripcion.setText(DatosCotizacion.get(0).getDescripcion());
                this.vistaC.jTNumeroCotizacion.setText(DatosCotizacion.get(0).getNumCotizacion());
                this.vistaC.jTPorcentajeCierre.setText(String.valueOf(DatosCotizacion.get(0).getPorcentajecierre()));
                this.vistaC.jFFestimadaCierre.setText(DatosCotizacion.get(0).getFechaEstCierre());

                for (int i = 0; i < TablaProdcutos.getRowCount(); i++) {

                    TablaProdcutos.removeRow(i);

                }

                for (DetalleCotizacion cdetalle : detalleCotiza) {
                    Object[] fila = {cdetalle.getCantidad(), cdetalle.getNumParte(), cdetalle.getProducto(), cdetalle.getPrecioVenta(), cdetalle.getPrecioTotal()};
                    TablaProdcutos.addRow(fila);

                }

                this.vistaC.jTSubTotal.setText(String.valueOf(detalleCotiza.get(0).getSubTotal()));
                this.vistaC.jTiva.setText(String.valueOf(detalleCotiza.get(0).getIva()));
                this.vistaC.jTTotal.setText(String.valueOf(detalleCotiza.get(0).getTotal()));

            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no Existe\n");
            }
        }

        if (e.getActionCommand() == "Eliminar") {
            String eProduct = this.vistaC.jTproductoEliminar.getText();
            for (int i = 0; i <= detalleCotiza.size(); i++) {
                String numparte = detalleCotiza.get(i).getNumParte();
                System.out.println("" + numparte);
                if (detalleCotiza.get(i).getNumParte().equals(eProduct)) {
                    detalleCotiza.remove(i);

                }
            }
            for (int i = 0; i <= TablaProdcutos.getRowCount(); i++) {
                System.out.println("" + TablaProdcutos.getRowCount());
                TablaProdcutos.removeRow(i);

            }

            for (DetalleCotizacion detalle : detalleCotiza) {
                Object[] fila = {detalle.getCantidad(), detalle.getNumParte(), detalle.getProducto(), detalle.getPrecioVenta(), detalle.getPrecioTotal()};
                TablaProdcutos.addRow(fila);

            }
            subtotal = 0;
            for (DetalleCotizacion detalle : detalleCotiza) {

                subtotal = subtotal + detalle.getPrecioTotal();

            }
            this.vistaC.jTSubTotal.setText(String.valueOf(decimales.format(subtotal)));
            this.vistaC.jTiva.setText(String.valueOf(decimales.format(iva = subtotal * 0.16)));
            this.vistaC.jTTotal.setText(String.valueOf(decimales.format(total = subtotal + iva)));
            this.vistaC.jTproductoEliminar.setText(null);
        }
        if ("Salir".equals(e.getActionCommand())) {

            VistaMenu vistamenu = new VistaMenu();
            ControladorMenu controladormenu = new ControladorMenu(vistamenu);

            this.vistaC.hide();

        }
    }

}
