/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CotizacionesDAO;
import Modelo.Cotizaciones;
import Vista.VistaCotizaciones;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pablo_Garcia
 */
public class ControladorCotizaciones implements ActionListener {
    
    private CotizacionesDAO modeloCotiza = new CotizacionesDAO();
    private ControladorProductos controladorP;
    private VistaCotizaciones vistaC;
    private VistaMenu vistaM;

    public ControladorCotizaciones(ControladorProductos controladorP, VistaCotizaciones vistaC, VistaMenu vistaM) {
        this.controladorP = controladorP;
        this.vistaC = vistaC;
        this.vistaM = vistaM;
        this.vistaC.jBbuscarProducto.addActionListener(this);
        this.vistaC.jBagregarproducto.addActionListener(this);
        this.vistaC.jBCrearCotizacion.addActionListener(this);
        this.vistaC.jBModificar.addActionListener(this);
        this.vistaC.jBConsultar.addActionListener(this);
        this.vistaC.jBSalir.addActionListener(this);
        
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getActionCommand()== "Buscar Producto"){
            
        }
        
        if (e.getActionCommand()=="Agregar"){
        
        }
        if(e.getActionCommand()=="Crear"){
        
        }
        if (e.getActionCommand()=="Modificar"){
        
        }
        if (e.getActionCommand()=="Consultar"){
        
        }
        
        if (e.getActionCommand()=="Salir"){
        
        }
    }
    
}
