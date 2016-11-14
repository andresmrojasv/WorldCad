/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.ControladorClientes;
import Modelo.ClientesDAO;
import Vista.VistaClientes;

/**
 *
 * @author Andrés
 */
public class AppClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaClientes vistaclientes=new VistaClientes();
        ClientesDAO clientesDAO=new ClientesDAO();
        
        ControladorClientes controladorclientes=new ControladorClientes(clientesDAO, vistaclientes);
        
    }
    
}
