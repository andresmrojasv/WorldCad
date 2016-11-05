/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author daybe
 */
public class VendedoresDAO {

    private Vendedores vendedor;
    ArrayList<Vendedores> ListaVendedor = new ArrayList();

    public void RegistrarVendedor(Vendedores vendedor) {
        ListaVendedor.add(vendedor);
        JOptionPane.showMessageDialog(null, " El vendedor se a registrado correctamente");
        if (vendedor == null) {
            JOptionPane.showMessageDialog(null, " Ha ocurrido un error intente nuevamente");
        }
    }

    public Vendedores ConsultarVendedor(int Identificacion) {
        Vendedores Consultar = null;
        for (Vendedores C : ListaVendedor) {
            if (Identificacion == C.Identificacion) {
                Consultar = C;
                break;
            }
        }
        return Consultar;
    }

    public void ModificarVendedor(int indice, Vendedores vendedor) {
        ListaVendedor.set(indice, vendedor);
    }

    public void EliminarVendedor(Vendedores vendedor) {
        ListaVendedor.remove(vendedor);
    }
    
}
