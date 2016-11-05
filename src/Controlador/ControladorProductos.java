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
        vistaProducto.jButRegistrar.setEnabled(false);
    }
    
    
}
