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

    public ControladorVendedores(VistaVendedores vistavendedor, VistaMenu vistamenu) throws IOException, ClassNotFoundException {
        this.vistavendedor = vistavendedor;
        this.vistamenu = vistamenu;
       
        this.vistavendedor.jBConsultar.addActionListener(this);
        this.vistavendedor.jBEliminar.addActionListener(this);
        this.vistavendedor.jBModificarVendedor.addActionListener(this);
        this.vistavendedor.jBRegistrarVendedor.addActionListener(this);
        this.vistavendedor.jCSucursal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == " Nuevo vendedor ") {

            vistavendedor.jBConsultar.setEnabled(false);
            vistavendedor.jBEliminar.setEnabled(false);
            vistavendedor.jBModificarVendedor.setEnabled(false);
            vistavendedor.jBNuevoVendedor.setEnabled(false);
            vistavendedor.jBRegistrarVendedor.setEnabled(true);
            vistavendedor.jBSalirVendedor.setEnabled(true);

            vistavendedor.jTCorreoVendedor.setEditable(true);
            vistavendedor.jTIdentVendedor.setEditable(true);
            vistavendedor.jTNombreVendedor.setEditable(true);
            vistavendedor.jCSucursal.setEditable(true);

        }
        if (e.getActionCommand() == " Registrar") {
            String identificacion = vistavendedor.jTIdentVendedor.getText();
            String nombre = vistavendedor.jTNombreVendedor.getText();
            String sucursal = vistavendedor.jCSucursal.getActionCommand();
            
            String correo = vistavendedor.jTCorreoVendedor.getText();

            vendedordao.RegistrarVendedor(new Vendedores(identificacion, nombre, sucursal, correo));

            vistavendedor.jBConsultar.setEnabled(true);
            vistavendedor.jBEliminar.setEnabled(true);
            vistavendedor.jBModificarVendedor.setEnabled(false);
            vistavendedor.jBNuevoVendedor.setEnabled(true);
            vistavendedor.jBRegistrarVendedor.setEnabled(false);
            vistavendedor.jBSalirVendedor.setEnabled(true);

            vistavendedor.jTCorreoVendedor.setEditable(false);
            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);

            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");

        }
        if (e.getActionCommand() == "Consultar") {
            ArrayList<Vendedores> vendedor = vendedordao.ConsultarVendedor(vistavendedor.jTIdentVendedor.getText());
            if (!vendedor.isEmpty()) {
                vistavendedor.jTIdentVendedor.setText(vendedor.get(0).getIdentificacion());
                vistavendedor.jTNombreVendedor.setText(vendedor.get(0).getNombre());
                vistavendedor.jTCorreoVendedor.setText(vendedor.get(0).getCorreo());

                vistavendedor.jTCorreoVendedor.setEditable(true);
                vistavendedor.jTIdentVendedor.setEditable(true);
                vistavendedor.jTNombreVendedor.setEditable(true);
                vistavendedor.jCSucursal.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(null, "El vendedor no existe ");
            }

        }
        if (e.getSource() == vistavendedor.jBModificarVendedor) {
            String identificacion = vistavendedor.jTIdentVendedor.getText();
            String nombre = vistavendedor.jTNombreVendedor.getText();
            String sucursal = vistavendedor.jCSucursal.getActionCommand();
            String correo = vistavendedor.jTCorreoVendedor.getText();

            vendedordao.ModificarVendedor(new Vendedores(identificacion, nombre, sucursal, correo));

            vistavendedor.jBConsultar.setEnabled(true);
            vistavendedor.jBNuevoVendedor.setEnabled(true);

            vistavendedor.jTCorreoVendedor.setEditable(false);
            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);

            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");

        }
        if (e.getActionCommand() == "Eliminar") {
            vendedordao.EliminarVendedor(vistavendedor.jTIdentVendedor.getText());

            vistavendedor.jTCorreoVendedor.setEditable(false);
            vistavendedor.jTIdentVendedor.setEditable(false);
            vistavendedor.jTNombreVendedor.setEditable(false);
            vistavendedor.jCSucursal.setEditable(false);

            vistavendedor.jTNombreVendedor.setText("");
            vistavendedor.jTIdentVendedor.setText("");
            vistavendedor.jTCorreoVendedor.setText("");
        }
        if (e.getSource() == vistavendedor.jBSalirVendedor) {
            this.vistavendedor.dispose();
            this.vistamenu.setVisible(true);

        }
    }

}
