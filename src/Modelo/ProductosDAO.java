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
        String sql ="insert into contacto(numero_parte,nombre,cantidad,precio_venta) values ('"+c.getNombreParte()+"','"+c.getNombreProducto()+"','"+c.getCantidad()+"','"+c.getPrecioVenta()+"')";
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
    
    public ArrayList<Productos> consultarProducto(String nomParte){
        ArrayList bProducto =new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta
        
        //Creamos la sentencia SQL
        String sql = "select * from productos where nombre_parte = '"+nomParte+"' ";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            if(rs.next()){
              Productos producto =new Productos(); 
              producto.setNombreParte(rs.getString("nombre_Parte"));
              producto.setNombreProducto(rs.getString("nombre"));
              producto.setCantidad(rs.getString("cantidad"));
              producto.setPrecioVenta(rs.getString("precio_venta"));
              bProducto.add(producto);
              
            }
           //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n"+e);
        }
        return bProducto; 
    }
    
    public void modificarProducto(Productos c){
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BD
        
        //Creamos la sentencia SQL
        String sql = "update contacto set movil='"+c.getNombreParte()+"',fijo='"+c.getNombreProducto()+"',correo='"+c.getCantidad()+"',web='"+c.getPrecioVenta()+"'";
        
        //Ejecuta la sentencia SQL
        try{
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar==1){
                JOptionPane.showMessageDialog(null,"Se ha modificado el contacto Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar el contacto");
            }
            
            //Cerramos conexiones
            conn.close();
            st.close();
        }catch(SQLException exe){
            exe.printStackTrace();
        }
    
    
    }
    
    public void eliminarProducto(String nombre){
    //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        //Creamos la sentencia SQL
        String sql = "delete from contacto where nombre= '"+nombre+"'";
        
        //Ejecuta la sentencia SQL
        try{
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar==1){
                JOptionPane.showMessageDialog(null,"Se ha eliminado el contacto Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar el contacto");
            }
            
            //Cerramos conexiones
            conn.close();
            st.close();
        }catch(SQLException exe){
            exe.printStackTrace();
        }
    }
}
