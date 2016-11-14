/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.ControladorCotizaciones;
import Modelo.CotizacionesDAO;
import Modelo.Productos;
import Modelo.ProductosDAO;
import Vista.VistaCotizaciones;
import Vista.VistaMenu;



/**
 *
 * @author Pablo_Garcia
 */
public class AppCotizacion {
    
    public static void main(String[] args) {
       VistaCotizaciones vistaCotiza = new VistaCotizaciones();
       ProductosDAO productos = new ProductosDAO();
       CotizacionesDAO CotizaDAO = new CotizacionesDAO();
       VistaMenu vistaM= new VistaMenu();
       
       ControladorCotizaciones ContoladorCotiza= new ControladorCotizaciones(productos,vistaCotiza,vistaM);
       
       vistaCotiza.setVisible(true);
    }
    
}
