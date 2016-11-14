/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import Modelo.ClientesDAO;
import Vista.VistaClientes;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTACION
 *
 *
 */
public class ControladorClientes implements ActionListener {

    private Clientes clientes;
    private ClientesDAO clientesdao = new ClientesDAO();
    private VistaClientes vistaclientes;

    public ControladorClientes(ClientesDAO clientesdao, VistaClientes vistaclientes) {
        this.clientesdao = clientesdao;
        this.vistaclientes = vistaclientes;

        this.vistaclientes.setVisible(true);

        this.vistaclientes.jBNuevoCliente.addActionListener(this);
        this.vistaclientes.jBRegistrar.addActionListener(this);
        this.vistaclientes.jBConsultar.addActionListener(this);
        this.vistaclientes.jBModificar.addActionListener(this);
        this.vistaclientes.jBEliminar.addActionListener(this);
        this.vistaclientes.jBSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("Nuevo Cliente".equals(e.getActionCommand())) {

            vistaclientes.jTNombreEmpresa.setEditable(true);
            vistaclientes.jTNombreContacto.setEditable(true);
            vistaclientes.jTDireccion.setEditable(true);
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
            long telefono = Long.parseLong(this.vistaclientes.jTTelefono.getText());
            String ciudad = (String) (this.vistaclientes.jCCiudad.getSelectedItem());

            this.clientesdao.registrarCliente(new Clientes(identificacion, nombreE, nombreC, direccion, correo, url, telefono, ciudad));

            vistaclientes.jTIdentificacion.setText("");
            vistaclientes.jTNombreEmpresa.setEditable(false);
            vistaclientes.jTNombreEmpresa.setText("");
            vistaclientes.jTNombreContacto.setEditable(false);
            vistaclientes.jTNombreContacto.setText("");
            vistaclientes.jTDireccion.setEditable(false);
            vistaclientes.jTDireccion.setText("");
            vistaclientes.jTCorreo.setEditable(false);
            vistaclientes.jTCorreo.setText("");
            vistaclientes.jTURL.setEditable(false);
            vistaclientes.jTURL.setText("");
            vistaclientes.jTTelefono.setEditable(false);
            vistaclientes.jTTelefono.setText("");

        }

        if ("Consultar".equals(e.getActionCommand())) {

            ArrayList<Clientes> DatosClientes = clientesdao.consultarClientes(Integer.parseInt(vistaclientes.jTIdentificacion.getText()));     //.consultarClientes(Integer.parseInt(this.vistaclientes.jTIdentificacion.getText()));

            if (!DatosClientes.isEmpty()) {
                this.vistaclientes.jTNombreEmpresa.setText(DatosClientes.get(0).getNombre_empresa());
                this.vistaclientes.jTNombreContacto.setText(DatosClientes.get(0).getNombre_contacto());
                this.vistaclientes.jTDireccion.setText(DatosClientes.get(0).getDireccion());
                this.vistaclientes.jTCorreo.setText(DatosClientes.get(0).getCorreo());
                this.vistaclientes.jTURL.setText(DatosClientes.get(0).getURL());
                this.vistaclientes.jTTelefono.setText(Long.toString(DatosClientes.get(0).getTelefono()));
                this.vistaclientes.jCCiudad.setSelectedItem(DatosClientes.get(0).getCiudad());
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no Existe\n");
            }

        }

        if ("Modificar".equals(e.getActionCommand())) {

            int identificacion = Integer.parseInt(this.vistaclientes.jTIdentificacion.getText());
            String nombreE = this.vistaclientes.jTNombreEmpresa.getText();
            String nombreC = this.vistaclientes.jTNombreContacto.getText();
            String direccion = this.vistaclientes.jTDireccion.getText();
            String correo = this.vistaclientes.jTCorreo.getText();
            String url = this.vistaclientes.jTURL.getText();
            long telefono = Long.parseLong(this.vistaclientes.jTTelefono.getText());
            String ciudad = (String) (this.vistaclientes.jCCiudad.getSelectedItem());

            this.clientesdao.modificarClientes(new Clientes(identificacion, nombreE, nombreC, direccion, correo, url, telefono, ciudad));

            vistaclientes.jTIdentificacion.setText("");
            vistaclientes.jTNombreEmpresa.setEditable(false);
            vistaclientes.jTNombreEmpresa.setText("");
            vistaclientes.jTNombreContacto.setEditable(false);
            vistaclientes.jTNombreContacto.setText("");
            vistaclientes.jTDireccion.setEditable(false);
            vistaclientes.jTDireccion.setText("");
            vistaclientes.jTCorreo.setEditable(false);
            vistaclientes.jTCorreo.setText("");
            vistaclientes.jTURL.setEditable(false);
            vistaclientes.jTURL.setText("");
            vistaclientes.jTTelefono.setEditable(false);
            vistaclientes.jTTelefono.setText("");

        }

        if ("Eliminar".equals(e.getActionCommand())) {

            clientesdao.eliminarContacto(Integer.parseInt(this.vistaclientes.jTIdentificacion.getText()));

            vistaclientes.jTIdentificacion.setText("");
            vistaclientes.jTNombreEmpresa.setEditable(false);
            vistaclientes.jTNombreEmpresa.setText("");
            vistaclientes.jTNombreContacto.setEditable(false);
            vistaclientes.jTNombreContacto.setText("");
            vistaclientes.jTDireccion.setEditable(false);
            vistaclientes.jTDireccion.setText("");
            vistaclientes.jTCorreo.setEditable(false);
            vistaclientes.jTCorreo.setText("");
            vistaclientes.jTURL.setEditable(false);
            vistaclientes.jTURL.setText("");
            vistaclientes.jTTelefono.setEditable(false);
            vistaclientes.jTTelefono.setText("");

        }
        
        if ("Salir".equals(e.getActionCommand())){
            
            VistaMenu vistamenu=new VistaMenu();
            ControladorMenu controladormenu=new ControladorMenu(vistamenu);
            
            this.vistaclientes.hide();
            
        }
    }

}