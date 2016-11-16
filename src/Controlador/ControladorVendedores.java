/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Vendedores;
import Modelo.VendedoresDAO;
import Vista.VistaMenu;
import Vista.VistaVendedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author daybe
 */
public class ControladorVendedores implements ActionListener {

    private VendedoresDAO vendedordao = new VendedoresDAO();
    private VistaVendedores vistavendedor;
    private VistaMenu vistamenu;
    private Vendedores vendedores;

    public ControladorVendedores(VistaVendedores vistavendedor, VistaMenu vistamenu) throws IOException, ClassNotFoundException {
        this.vendedordao = vendedordao;
        this.vistavendedor = vistavendedor;

        this.vistavendedor.jBConsultar.addActionListener(this);
        this.vistavendedor.jBEliminar.addActionListener(this);
        this.vistavendedor.jBModificarVendedor.addActionListener(this);
        this.vistavendedor.jBCrregistrar.addActionListener(this);
        this.vistavendedor.jCSucursal.addActionListener(this);
        this.vistavendedor.jBnuevoCliente.addActionListener(this);
        this.vistavendedor.jBVistaMENU.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Nuevo Vendedor") {
            System.out.println("1");
            vistavendedor.jBConsultar.setEnabled(true);
            vistavendedor.jBEliminar.setEnabled(false);
            vistavendedor.jBModificarVendedor.setEnabled(false);
            vistavendedor.jBnuevoCliente.setEnabled(false);
            vistavendedor.jBCrregistrar.setEnabled(true);
            vistavendedor.jBVistaMENU.setEnabled(true);

            vistavendedor.jTIdentVendedor.setEditable(true);
            vistavendedor.jTNombreVendedor.setEditable(true);
            vistavendedor.jCSucursal.setEditable(true);
            vistavendedor.jTCorreoVendedor.setEditable(true);

            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");

        }
        if (e.getActionCommand() == "Registrar") {
            System.out.println("1");
            int identificacion = Integer.parseInt(vistavendedor.jTIdentVendedor.getText());
            String nombre = this.vistavendedor.jTNombreVendedor.getText();
            String Ciudades = (String) (this.vistavendedor.jCSucursal.getSelectedItem());
            String correo = this.vistavendedor.jTCorreoVendedor.getText();

            this.vendedordao.RegistrarVendedor(new Vendedores(identificacion, nombre, Ciudades, correo));

            vistavendedor.jBConsultar.setEnabled(true);
            vistavendedor.jBEliminar.setEnabled(true);
            vistavendedor.jBModificarVendedor.setEnabled(false);
            vistavendedor.jBCrregistrar.setEnabled(false);
            vistavendedor.jBVistaMENU.setEnabled(true);

            vistavendedor.jTCorreoVendedor.setEditable(false);
            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);

            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");

        }

        if (e.getActionCommand() == "Consultar") {
            ArrayList<Vendedores> vendedor = vendedordao.ConsultarVendedor(vistavendedor.jTIdentVendedor.getText());
            if (!vendedor.isEmpty()) {

                vistavendedor.jTNombreVendedor.setText(vendedor.get(0).getNombre());
                vistavendedor.jCSucursal.setSelectedItem(vendedor.get(0).getCiudades());
                vistavendedor.jTCorreoVendedor.setText(vendedor.get(0).getCorreo());

                vistavendedor.jTIdentVendedor.setEditable(true);
                vistavendedor.jTNombreVendedor.setEditable(true);
                vistavendedor.jCSucursal.setEditable(true);
                vistavendedor.jTCorreoVendedor.setEditable(true);

            } else {
                JOptionPane.showMessageDialog(null, "El vendedor no existe ");

                vistavendedor.jTCorreoVendedor.setText("");
                vistavendedor.jTNombreVendedor.setText("");
                vistavendedor.jTIdentVendedor.setText("");

            }

        }
        if (e.getActionCommand() == "Modificar") {

            int identificacion = Integer.parseInt(vistavendedor.jTIdentVendedor.getText());
            String nombre = vistavendedor.jTNombreVendedor.getText();
            String Ciudades = (String) (this.vistavendedor.jCSucursal.getSelectedItem());
            String correo = vistavendedor.jTCorreoVendedor.getText();

            VendedoresDAO.ModificarVendedor(new Vendedores(identificacion, nombre, Ciudades, correo));

            vistavendedor.jBnuevoCliente.setEnabled(true);
            vistavendedor.jBConsultar.setEnabled(true);
            vistavendedor.jBVistaMENU.setEnabled(true);

            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);
            vistavendedor.jTCorreoVendedor.setEditable(false);

            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");

        }
        if (e.getActionCommand() == "Eliminar") {
            vendedordao.EliminarVendedor(vistavendedor.jTIdentVendedor.getText());

            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);
            vistavendedor.jTCorreoVendedor.setEditable(false);

            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");
        }
        if ("Menu".equals(e.getActionCommand())) {

            VistaMenu vistamenu = new VistaMenu();
            ControladorMenu controladormenu = new ControladorMenu(vistamenu);
            this.vistavendedor.hide();
          

        }
    }

}
