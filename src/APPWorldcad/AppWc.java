/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APPWorldcad;

import Controlador.ControladorMenu;
import Controlador.ControladorVendedores;
import Modelo.VendedoresDAO;
import Vista.VistaMenu;
import Vista.VistaVendedores;

/**
 *
 * @author daybe
 */
public class AppWc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaMenu vistaM = new VistaMenu();
        ControladorMenu ControladorM = new ControladorMenu(vistaM);
        vistaM.setVisible(true);
        
       
        
    }
    
}
