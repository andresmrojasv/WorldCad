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
 * @author Andrés
 */
public class ClientesDAO {

    private Clientes clientes;

    public void registrarCliente(Clientes c) {
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection(); //Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BBDD
        //Creamos la sentencia SQL
        String sql = "insert into Clientes(identificacion, nombre_empresa, nombre_contacto, direccion, correo, url, telefono,ciudad_id) values ('" + c.getIdentificacion() + "','" + c.getNombre_empresa() + "','" + c.getNombre_contacto() + "','" + c.getDireccion() + "','" + c.getCorreo() + "','" + c.getURL() + "','" + c.getTelefono() + "',(select CIUDAD_ID from CIUDADES where CIUDAD='" + c.getCiudad() + "'))";
        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            //Cerramos conexiones
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado un Cliente Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro el Cliente");
        }

    }

    public ArrayList<Clientes> consultarClientes(int identificacion) {
        ArrayList ListaClientes = new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta

        //Creamos la sentencia SQL
        String sql = "SELECT IDENTIFICACION, NOMBRE_EMPRESA, NOMBRE_CONTACTO,DIRECCION,CORREO, URL, TELEFONO, CIUDAD FROM CLIENTES, CIUDADES WHERE (CLIENTES.CIUDAD_ID = CIUDADES.CIUDAD_ID) and IDENTIFICACION = '" + identificacion + "'  ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos de la consulta
            if (rs.next()) {
                Clientes datos = new Clientes();
                datos.setIdentificacion(rs.getInt("identificacion"));
                datos.setNombre_empresa(rs.getString("Nombre_Empresa"));
                datos.setNombre_contacto(rs.getString("Nombre_Contacto"));
                datos.setDireccion(rs.getString("Direccion"));
                datos.setCorreo(rs.getString("Correo"));
                datos.setURL(rs.getString("URL"));
                datos.setTelefono(rs.getLong("telefono"));
                datos.setCiudad(rs.getString("ciudad"));
                ListaClientes.add(datos);
            }
            //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n" + e);
        }
        return ListaClientes;
    }

    public void modificarClientes(Clientes c) {
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BD

        //Creamos la sentencia SQL
        String sql = "update clientes set nombre_empresa='" + c.getNombre_empresa() + "',nombre_contacto='" + c.getNombre_contacto() + "',direccion='" + c.getDireccion() + "',correo='" + c.getCorreo() + "',url='" + c.getURL() + "',telefono='" + c.getTelefono() + "', ciudad_id=(select CIUDAD_ID from CIUDADES where CIUDAD='" + c.getCiudad() + "') WHERE IDENTIFICACION = '" + c.getIdentificacion() + "'";

        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el Cliente Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el Cliente");
            }

            //Cerramos conexiones
            conn.close();
            st.close();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }

    }

    public void eliminarContacto(int identificacion) {
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        //Creamos la sentencia SQL
        String sql = "delete from clientes where identificacion= '" + identificacion + "'";

        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el Cliente Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Cliente");
            }

            //Cerramos conexiones
            conn.close();
            st.close();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }

}
