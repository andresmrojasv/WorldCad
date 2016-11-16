/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.ControladorVendedores;
import Modelo.VendedoresDAO;
import Vista.VistaVendedores;

/**
 *
 * @author daybe
 */
public class AppVendedor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaVendedores vistaV = new VistaVendedores();
        VendedoresDAO vendedoresDAO = new VendedoresDAO();
        
        //ControladorVendedores controladorvendedores = new ControladorVendedores(vendedoresDAO, vistaV);
        
    }
    
}
