/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import Vista.VistaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ESTACION
 */
public class ControladorClientes implements ActionListener {

    Clientes clientes;
    VistaClientes vistaclientes;

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Nuevo Cliente".equals(e.getActionCommand())) {

            vistaclientes.jTNombreEmpresa.setEnabled(true);
            vistaclientes.jTDireccion.setEnabled(true);
            vistaclientes.jTCorreo.setEditable(true);

        }

    }

}
