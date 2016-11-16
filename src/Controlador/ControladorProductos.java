 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Productos;
import Modelo.ProductosDAO;
import Vista.VistaProductos;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorProductos implements ActionListener{
    private ProductosDAO modelo = new ProductosDAO();
    private VistaProductos vistaProducto;
    private ProductosDAO productosDao;
    private VistaMenu vistaMenu;

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

    ControladorProductos(VistaProductos vistaP, VistaMenu vistaM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            String cantidad =  vistaProducto.jTcantidad.getText();
            String precioVenta = vistaProducto.jTprecioVenta.getText();
            
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
        
       /* if(e.getActionCommand() == "Consultar"){
            ArrayList<Productos> producto = modelo.consultarProducto(vistaProducto.jTnomParte.getText());
            
            if(!producto.isEmpty()){
              
                vistaProducto.jTcantidad.setText(producto.get(0).getCantidad());
                vistaProducto.jTnomParte.setText(producto.get(0).getNombreParte());
                vistaProducto.jTnomProducto.setText(producto.get(0).getNombreProducto());
                vistaProducto.jTprecioVenta.setText(producto.get(0).getPrecioVenta());
                vistaProducto.jTcantidad.setEditable(false);
                vistaProducto.jTnomParte.setEditable(false);
                vistaProducto.jTnomProducto.setEditable(false);
                vistaProducto.jTprecioVenta.setEnabled(false);
         
           }else{
               JOptionPane.showMessageDialog(null, "El Contacto no Existe\n");
           }
        
        }*/
        
        if(e.getActionCommand() == "Modificar" ){
           String nomParte = vistaProducto.jTnomParte.getText();
           String nomProducto = vistaProducto.jTnomProducto.getText();
           String cantidad = vistaProducto.jTcantidad.getText();
           String precioVenta = vistaProducto.jTprecioVenta.getText();
           
           modelo.modificarProducto(new Productos(nomParte,nomProducto,cantidad,precioVenta));
                     
           vistaProducto.jButConsultar.setEnabled(true);
           vistaProducto.jButnProducto.setEnabled(true);
           
           vistaProducto.jTcantidad.setEditable(false);
           vistaProducto.jTnomParte.setEditable(false);
           vistaProducto.jTnomProducto.setEditable(false);
           vistaProducto.jTprecioVenta.setEnabled(false);
           
           vistaProducto.jTcantidad.setText("");
           vistaProducto.jTnomParte.setText("");
           vistaProducto.jTnomProducto.setText("");
           vistaProducto.jTprecioVenta.setText("");
             
       }
        
        if(e.getActionCommand() == "Eliminar"){
           modelo.eliminarProducto(vistaProducto.jTnomParte.getText());
           
           vistaProducto.jTcantidad.setEditable(false);
           vistaProducto.jTnomProducto.setEditable(false);
           vistaProducto.jTprecioVenta.setEditable(false);
           
           vistaProducto.jTcantidad.setText("");
           vistaProducto.jTnomParte.setText("");
           vistaProducto.jTnomProducto.setText("");
           vistaProducto.jTprecioVenta.setText("");
           
       }
        
        if(e.getSource() == vistaProducto.jButSalir){
           this.vistaProducto.dispose();
           this.vistaMenu.setVisible(true);
       
       }
        
    }
    
    
}
