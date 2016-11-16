
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Conexion.Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author daybe
 */
public class VendedoresDAO {
    private Vendedores vendedores;

    public static void RegistrarVendedor(Vendedores v) {
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        String sql = "INSERT INTO VENDEDORES(IDENTIFICACION, NOMBRE, CIUDAD_ID, CORREO) VALUES ('" + v.getIdentificacion() + "','" + v.getNombre() + "',(SELECT CIUDAD_ID FROM CIUDADES WHERE CIUDAD='" + v.getCiudades() + "'),'" + v.getCorreo() + "')";
        try {

            st = conec.createStatement();
            st.executeUpdate(sql);
            conec.close();
            st.close();           
            JOptionPane.showMessageDialog(null, "Se ha registrado el vendedor correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro el vendedor ss");
        }
    }

    public static ArrayList<Vendedores> ConsultarVendedor(String Identificacion) {
        ArrayList miVendedor = new ArrayList();
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        ResultSet rs;

        String sql = " SELECT IDENTIFICACION, NOMBRE, CIUDAD, CORREO FROM VENDEDORES, CIUDADES WHERE (VENDEDORES.CIUDAD_ID = CIUDADES.CIUDAD_ID) AND IDENTIFICACION = "+ Identificacion + "";
        try {
            st = conec.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Vendedores vendedor = new Vendedores();
                vendedor.setIdentificacion(rs.getInt("IDENTIFICACION"));
                vendedor.setNombre(rs.getString("NOMBRE"));
                vendedor.setCiudades(rs.getString("CIUDAD"));
                vendedor.setCorreo(rs.getString("CORREO"));
                miVendedor.add(vendedor);

            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException v) {
            v.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar el vendedor"+v);
        }
        return miVendedor;
    }

    public static void ModificarVendedor(Vendedores v) {
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        String sql = "UPDATE VENDEDORES SET NOMBRE ='" + v.getNombre() + "', CIUDAD_ID=(SELECT CIUDAD_ID FROM CIUDADES WHERE CIUDAD='" + v.getCiudades() + "'), CORREO ='" + v.getCorreo() + "' WHERE IDENTIFICACION = '" + v.getIdentificacion() + "'";
        try {
            st = conec.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el vendedor exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Erro al modificar el vendedor");
            }
            conec.close();
            st.close();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }

    }

    public static void EliminarVendedor(String Identificacion) {
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        String sql = "DELETE FROM VENDEDORES  WHERE IDENTIFICACION = '" + Identificacion + "'";

        try {
            st = conec.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el vendedor exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el vendedor");
            }
            conec.close();
            st.close();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }

}
