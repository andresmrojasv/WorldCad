/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VendedoresDAO;
import Vista.VistaVendedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author daybe
 */
public class ControladorVendedores implements ActionListener {
    
    private VendedoresDAO vendedordao = new VendedoresDAO();
    private VistaVendedores vistavendedor;

    public ControladorVendedores(VendedoresDAO vendedordao, VistaVendedores vistavendedor) {
        
        this.vendedordao = vendedordao;
        this.vistavendedor = vistavendedor;

        this.vistavendedor.setVisible(true);

        this.vistavendedor.jBRegistrarVendedor.addActionListener(this);
        this.vistavendedor.jBConsultar.addActionListener(this);
        this.vistavendedor.jBEliminar.addActionListener(this);
        this.vistavendedor.jBSalirVendedor.addActionListener(this);
        this.vistavendedor.jCSucursal.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == " Registrar"){
            vistavendedor.jBRegistrarVendedor.setEnabled(true);
            vistavendedor.jBConsultar.setEnabled(false);
            vistavendedor.jBEliminar.setEnabled(false);
            vistavendedor.jBModificarVendedor.setEnabled(false);
            vistavendedor.jBSalirVendedor.setEnabled(true);
            
          vistavendedor.jTCorreoVendedor.setEditable(true);
          vistavendedor.jTIdentVendedor.setEditable(true);
          vistavendedor.jTNombreVendedor.setEditable(true);

        }        
        if (e.getActionCommand() == " Regidtrar"){
           
            
        }
    }
   

    
}

