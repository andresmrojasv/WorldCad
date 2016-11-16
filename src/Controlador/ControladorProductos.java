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
    private Productos producto = new Productos(); 
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
        this.vistaProducto.jBNuevoProducto.addActionListener(this);
        this.vistaProducto.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    
        if(e.getActionCommand() == "Nuevo Producto"){
        vistaProducto.jButRegistrar.setEnabled(true);
        vistaProducto.jButConsultar.setEnabled(true);
        vistaProducto.jButModificar.setEnabled(true);
        vistaProducto.jButSalir.setEnabled(true);
        vistaProducto.jBNuevoProducto.setEnabled(true);
        
        
        
        vistaProducto.jTnomParte.setEditable(true);
        vistaProducto.jTcantidad.setEditable(true);
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
            vistaProducto.jButModificar.setEnabled(true);
            vistaProducto.jButSalir.setEnabled(true);
            vistaProducto.jBNuevoProducto.setEnabled(true);
            
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
              
                vistaProducto.jTcantidad.setText(producto.get(0).getCantidad());
                vistaProducto.jTnomParte.setText(producto.get(0).getNombreParte());
                vistaProducto.jTnomProducto.setText(producto.get(0).getNombreProducto());
                vistaProducto.jTprecioVenta.setText(producto.get(0).getPrecioVenta());
                vistaProducto.jTcantidad.setEditable(true);
                vistaProducto.jTnomParte.setEditable(true);
                vistaProducto.jTnomProducto.setEditable(true);
                vistaProducto.jTprecioVenta.setEnabled(true);
         
           }else{
               JOptionPane.showMessageDialog(null, "El Producto no Existe\n");
           }
        
        }
        
        if(e.getActionCommand() == "Modificar" ){
           String nomParte = vistaProducto.jTnomParte.getText();
           String nomProducto = vistaProducto.jTnomProducto.getText();
           String cantidad = vistaProducto.jTcantidad.getText();
           String precioVenta = vistaProducto.jTprecioVenta.getText();
           
          this.modelo.modificarProducto(new Productos(nomParte,nomProducto,cantidad,precioVenta));
                     
           vistaProducto.jButConsultar.setEnabled(true);
           vistaProducto.jBNuevoProducto.setEnabled(true);
           vistaProducto.jButModificar.setEnabled(true);
           
           vistaProducto.jTcantidad.setEditable(true);
           vistaProducto.jTnomParte.setEditable(true);
           vistaProducto.jTnomProducto.setEditable(true);
           vistaProducto.jTprecioVenta.setEnabled(true);
           
           vistaProducto.jTcantidad.setText("");
           vistaProducto.jTnomParte.setText("");
           vistaProducto.jTnomProducto.setText("");
           vistaProducto.jTprecioVenta.setText("");
             
       }
        
        if(e.getActionCommand() == "Eliminar"){
           //String numparte= vistaProducto.jTnomParte.getText();
            modelo.eliminarProducto(String.valueOf(vistaProducto.jTnomParte.getText()));
           
           vistaProducto.jTcantidad.setEditable(false);
           vistaProducto.jTnomProducto.setEditable(false);
           vistaProducto.jTprecioVenta.setEditable(false);
           
           vistaProducto.jTcantidad.setText("");
           vistaProducto.jTnomParte.setText("");
           vistaProducto.jTnomProducto.setText("");
           vistaProducto.jTprecioVenta.setText("");
           
       }
        
        if ("Salir".equals(e.getActionCommand())){
            
            VistaMenu vMenu = new VistaMenu();
            ControladorMenu controladormenu=new ControladorMenu(vMenu);
            
            this.vistaProducto.hide();
         
            
        }
        
    }
    
    
}