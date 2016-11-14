/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ClientesDAO;
import Modelo.ProductosDAO;
import Modelo.VendedoresDAO;
import Vista.VistaClientes;
import Vista.VistaCotizaciones;
import Vista.VistaMenu;
import Vista.VistaProductos;
import Vista.VistaVendedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorMenu implements ActionListener{
    
    private VistaMenu vistaM;

    public ControladorMenu(VistaMenu vistaM) {
        this.vistaM = vistaM;
        this.vistaM.jMCliente.addActionListener(this);
        this.vistaM.jMCotizar.addActionListener(this);
        this.vistaM.jMProducto.addActionListener(this);
        this.vistaM.jMVendedor.addActionListener(this);
        
        this.vistaM.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand() == "+ Contacto"){
            
        }
    }
    
}
