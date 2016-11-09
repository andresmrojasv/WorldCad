/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class ClientesDAO {
    
    private Clientes clientes;
    
    ArrayList <Clientes> ListaClientes=new ArrayList();

    public ClientesDAO(Clientes clientes) {
        this.clientes = clientes;
    }
    
    /*public void registrarTitular (Clientes c) {
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection(); //Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BBDD
        //Creamos la sentencia SQL
        String sql = "insert into Titular(Cedula, nombres, apellidos, email) values ('" + c.getCedula() + "','" + c.getNombres() + "','" + c.getApellidos() + "','" + c.getEmail() + "')";
        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            //Cerramos conexiones
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado un contacto Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el contacto");
        }
    

    } */

    public Clientes buscarCliente(int codigo) {
        Clientes buscar = null;
        for (Clientes p : ListaClientes) {
            if (codigo == p.getIdentificacion()) {
                buscar = p;
                break;
            }
        }
        return buscar;
    }


    public void modificaProducto(int indice, Clientes cuenta) {

        ListaClientes.set(indice, cuenta);

    }

    public void elimaProducto(Clientes cuenta) {
        ListaClientes.remove(cuenta);
    }

    public ArrayList<Clientes> listaDeCuentas() {
        return ListaClientes;
    }
    
}
