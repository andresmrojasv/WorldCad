/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Productos;
import Modelo.ProductosDAO;
import Vista.VistaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorProductos implements ActionListener{
    private ProductosDAO modelo = new ProductosDAO();
    private VistaProductos vistaProducto;
    private ProductosDAO productosDao;

    public ControladorProductos(VistaProductos vistaProducto, ProductosDAO productosDao) {
        this.vistaProducto = vistaProducto;
        this.productosDao = productosDao;
        
        this.vistaProducto.jButRegistrar.addActionListener(this);
        this.vistaProducto.jButModificar.addActionListener(this);
        this.vistaProducto.jButEliminar.addActionListener(this);
        this.vistaProducto.jButConsultar.addActionListener(this);
        this.vistaProducto.jButSalir.addActionListener(this);
        this.vistaProducto.jButnProducto.addActionListener(this);
        this.vistaProducto.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Nuevo Producto"){
            vistaProducto.jButRegistrar.setEnabled(true);
            vistaProducto.jButConsultar.setEnabled(false);
            vistaProducto.jButModificar.setEnabled(false);
            vistaProducto.jButSalir.setEnabled(true);
            vistaProducto.jButnProducto.setEnabled(false);
            
            vistaProducto.jTnomParte.setEditable(true);
            vistaProducto.jTnomParte.setEditable(true);
            vistaProducto.jTnomProducto.setEditable(true);
            vistaProducto.jTprecioVenta.setEditable(true);
            
        }
        
        if(e.getActionCommand() == "Registrar"){
            
            String nomParte = vistaProducto.jTnomParte.getText();
            String nomProducto = vistaProducto.jTnomProducto.getText();
            int cantidad =  Integer.parseInt(vistaProducto.jTcantidad.getText());
            float precioVenta = Float.parseFloat(vistaProducto.jTprecioVenta.getText());
            
            modelo.registrarProducto(new Productos(nomParte,nomProducto,cantidad,precioVenta));
            
            vistaProducto.jButRegistrar.setEnabled(true);
            vistaProducto.jButConsultar.setEnabled(true);
            vistaProducto.jButModificar.setEnabled(false);
            vistaProducto.jButSalir.setEnabled(true);
            vistaProducto.jButnProducto.setEnabled(true);
            
            vistaProducto.jTnomParte.setEditable(true);
            vistaProducto.jTnomParte.setEditable(true);
            vistaProducto.jTnomProducto.setEditable(true);
            vistaProducto.jTprecioVenta.setEditable(true);
            
            vistaProducto.jTcantidad.setText("");
            vistaProducto.jTnomParte.setText("");
            vistaProducto.jTnomProducto.setText("");
            vistaProducto.jTprecioVenta.setText("");
            
        }
        
        if(e.getActionCommand() == "Consultar"){
            ArrayList<Productos> producto = modelo.consultarProducto(vistaProducto.jTnomParte.getText());
            
            if(!producto.isEmpty()){
              
                vistaProducto.jTcantidad.setText((Integer.parseInt(producto.get(0).getCantidad())));
                
                /*vistaC.jTtelMovil1.setText(contacto.get(0).getTelefonoMovil());
                vistaC.jTtelFijo1.setText(contacto.get(0).getTelefonoFio());
                vistaC.jTdCorreo.setText(contacto.get(0).getDireccioCorreo());
                vistaC.jTsitioWeb.setText(contacto.get(0).getSitioWeb());
                vistaC.jTtelMovil1.setEditable(true);
                vistaC.jTtelFijo1.setEditable(true);
                vistaC.jTdCorreo.setEditable(true);
                vistaC.jTsitioWeb.setEditable(true);
                vistaC.jBborarContacto.setEnabled(true);
                vistaC.jBmodificar.setEnabled(true);*/
           }else{
               JOptionPane.showMessageDialog(null, "El Contacto no Existe\n");
           }
        
        }
        
    }
    
    
}
