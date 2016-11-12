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
 * @author Pablo_Garcia
 */
public class CotizacionesDAO {
    
    public static void registrarCotizacion(Cotizaciones cotiza) {
        //Conexion y carga BD
        Conexion.Connection(); 
        Connection conn = Conexion.getCnnection(); //Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BBDD
         //Creamos la sentencia SQL
        String sql ="INSERT INTO COTIZACIONES (CLIENTES_ID,VENDEDORES_ID,FECHA_CREACION, FECHA_EST_CIERRE,PORCENTAJE_CIERRE,DESCRIPCION,NUMERO_COTIZACION) ((SELECT CLIENTES_ID FROM CLIENTES WHERE NOMBRE_EMPRESA= '"+cotiza.getCliente()+"'),(SELECT VENDEDORES_ID FROM VENDEDORES WHERE NOMBRE = '"+cotiza.getVendedor()+"'),'"+cotiza.getFechaCreacion()+"','"+cotiza.getFechaEstCierre()+"','"+cotiza.getPorcentajeCierre()+"','"+cotiza.getDescripcion()+"','"+cotiza.getNumCotizacion()+"')";
         //Ejecuta la sentencia SQL
        try{
            st = conn.createStatement();
            st.executeUpdate(sql);
            //Cerramos conexiones
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado la cotización Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la cotización");
        }
    }
    
    public static void modificarCotizacion(Cotizaciones cotiza){
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BD
        
        //Creamos la sentencia SQL
        String sql = "UPDATE COTIZACIONES SET FECHA_EST_CIERRE='"+cotiza.getFechaEstCierre()+"',PORCENTAJE_CIERRE='"+cotiza.getPorcentajeCierre()+"',DESCRIPCION='"+cotiza.getDescripcion()+"' WHERE NUMERO_COTIZACION = '"+cotiza.getNumCotizacion()+"'";
        
        //Ejecuta la sentencia SQL
        try{
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar==1){
                JOptionPane.showMessageDialog(null,"Se ha modificado la cotización exitosamente");
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar la cotización");
            }
            
            //Cerramos conexiones
            conn.close();
            st.close();
        }catch(SQLException exe){
            exe.printStackTrace();
        }
    
    
    }
    
    public static ArrayList<Cotizaciones> consultarCotizacion(String numCotizacion){
        ArrayList cotizacion =new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta
        
        //Creamos la sentencia SQL
        String sql = "SELECT CLIENTES.NOMBRE_EMPRESA,VENDEDORES.NOMBRE, FECHA_EST_CIERRE,PORCENTAJE_CIERRE,DESCRIPCION,NUMERO_COTIZACION FROM COTIZACIONES,CLIENTES,VENDEDORES WHERE (COTIZACIONES.CLIENTES_ID= CLIENTES.CLIENTES_ID) AND (COTIZACIONES.VENDEDORES_ID=VENDEDORES.VENDEDORES_ID) AND (NUMERO_COTIZACION= '"+numCotizacion+"' ";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            if(rs.next()){
              Cotizaciones Cotiza =new Cotizaciones(); 
              Cotiza.setCliente(rs.getString("NOMBRE_EMPRESA"));
              Cotiza.setVendedor(rs.getString("NOMBRE"));
              Cotiza.setFechaEstCierre(rs.getString("FECHA_EST_CIERRE"));
              Cotiza.setPorcentajeCierre((rs.getDouble("PORCENTAJE_CIERRE")));
              Cotiza.setDescripcion(rs.getString("DESCRIPCION"));
              Cotiza.setNumCotizacion(rs.getString("NUMERO_COTIZACION"));
              cotizacion.add(Cotiza);
            }
           //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n"+e);
        }
        return cotizacion; 
    }
    
}
