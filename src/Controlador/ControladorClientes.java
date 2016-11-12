/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import Modelo.ClientesDAO;
import Vista.VistaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ESTACION
 */
public class ControladorClientes implements ActionListener {

    Clientes clientes;
    ClientesDAO clientesdao;
    VistaClientes vistaclientes;

    public ControladorClientes(Clientes clientes, VistaClientes vistaclientes) {
        this.clientes = clientes;
        this.vistaclientes = vistaclientes;

        this.vistaclientes.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Nuevo Cliente".equals(e.getActionCommand())) {

            vistaclientes.jTNombreEmpresa.setEnabled(true);
            vistaclientes.jTDireccion.setEnabled(true);
            vistaclientes.jTCorreo.setEditable(true);
            vistaclientes.jTURL.setEditable(true);
            vistaclientes.jTTelefono.setEditable(true);

        }

        if ("Registrar".equals(e.getActionCommand())) {

            int identificacion = Integer.parseInt(this.vistaclientes.jTIdentificacion.getText());
            String nombreE = this.vistaclientes.jTNombreEmpresa.getText();
            String nombreC = this.vistaclientes.jTNombreContacto.getText();
            String direccion = this.vistaclientes.jTDireccion.getText();
            String correo = this.vistaclientes.jTCorreo.getText();
            String url = this.vistaclientes.jTURL.getText();
            int telefono = Integer.parseInt(this.vistaclientes.jTTelefono.getText());

            this.clientesdao.registrarCliente(new Clientes(identificacion, nombreE, nombreC, direccion, correo, url, telefono, "ciudad"));

        }

        if ("Consultar".equals(e.getActionCommand())) {

        }

    }

}
