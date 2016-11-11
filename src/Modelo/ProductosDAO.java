/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTACION
 */
public class ProductosDAO {
    public void registrarProducto(Productos c) {
        //Conexion y carga BD
        Conexion.Connection(); 
        Connection conn = Conexion.getCnnection(); //Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BBDD
         //Creamos la sentencia SQL
        String sql ="insert into contacto(nombre,movil,fijo,correo,web) values ('"+c.getNombreParte()+"','"+c.getNombreProducto()+"','"+c.getCantidad()+"','"+c.getPrecioVenta()+"')";
         //Ejecuta la sentencia SQL
        try{
            st = conn.createStatement();
            st.executeUpdate(sql);
            //Cerramos conexiones
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado un producto Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el producto");
        }
    }
}
