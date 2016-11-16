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

public class ControladorMenu implements ActionListener {

    private VistaMenu vistaM;

    public ControladorMenu(VistaMenu vistaM) {
        this.vistaM = vistaM;
        this.vistaM.jMCliente.addActionListener(this);
        this.vistaM.jMCotizar.addActionListener(this);
        this.vistaM.jMProducto.addActionListener(this);
        this.vistaM.jMVendedor.addActionListener(this);
        this.vistaM.jMSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Vendedor") {
            VistaVendedores VistaV = new VistaVendedores();
            try {
                ControladorVendedores controladorV = new ControladorVendedores(VistaV, vistaM);
            } catch (IOException ex) {
                Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            VistaV.setVisible(true);
            vistaM.setVisible(false);
            vistaM.hide();
        }
        if (e.getActionCommand() == "Cliente") {
            try {
                VistaClientes vistaC = new VistaClientes();
                ControladorClientes ControladorC = new ControladorClientes(vistaC, vistaM);
                vistaC.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ("Producto".equals(e.getActionCommand())) {

            VistaProductos vistaP = new VistaProductos();
           

            vistaP.setVisible(true);
        }

        if ("Cotizar".equals(e.getActionCommand())) {
            VistaCotizaciones Vcotizaciones = new VistaCotizaciones();
            Vcotizaciones.setVisible(true);

        }
        if ("Salir".equals(e.getActionCommand())) {
            System.exit(0);
        }

        if (e.getSource() == vistaM.jMSalir) {
            System.exit(0);
        }

    }

}
