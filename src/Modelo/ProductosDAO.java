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
    
    public ArrayList<Productos> consultarProducto(String nombre){
        ArrayList miContacto =new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta
        
        //Creamos la sentencia SQL
        String sql = "select * from contacto where nombre = '"+nombre+"' ";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            if(rs.next()){
              ContactoVO contacto =new ContactoVO(); 
              contacto.setContacto(rs.getString("nombre"));
              contacto.setTelefonoMovil(rs.getString("movil"));
              contacto.setTelefonoFio(rs.getString("fijo"));
              contacto.setDireccioCorreo(rs.getString("correo"));
              contacto.setSitioWeb(rs.getString("web"));
              miContacto.add(contacto);
            }
           //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n"+e);
        }
        return miContacto; 
    }
}
