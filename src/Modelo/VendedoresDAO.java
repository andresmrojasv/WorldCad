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

    public static void RegistrarVendedor(Vendedores v) {
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        String sql = " INSERT INTO VENDEDORES(IDENTIFICACION, NOMBRE, CORREO, CIUDAD_ID') VALUES ('" + v.getIdentificacion() + "," + v.getNombre() + "," + v.getCorreo() + "," + v.getSucursal() + "')";
        try {

            st = conec.createStatement();
            st.equals(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado el vendedor correctamente", "Informecion", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se regidtro el vendedor");
        }
    }

    public static ArrayList<Vendedores> ConsultarVendedor(String Identificacion) {
        ArrayList miVendedor = new ArrayList();
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        ResultSet rs;

        String sql = " SELECT IDENTIFICACION, NOMBRE,  CORREO, CIUDAD_ID FROM VENDEDORES WHERE IDENTIFICACION FROM VENDEDORES = '" + Identificacion + '"';
        try {
            st = conec.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Vendedores vendedor = new Vendedores();
                vendedor.setIdentificacion(rs.getString("IDENTIFICACION"));
                vendedor.setNombre(rs.getString("NOMBRE"));
                vendedor.setSucursal(rs.getString("CIUDAD_ID"));
                vendedor.setCorreo(rs.getString("CORREO"));
                miVendedor.add(vendedor);

            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException v) {
            v.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar el vendedor\n"+v);
        }
        return miVendedor;
    }

    public static void ModificarVendedor(Vendedores v) {
        Conexion.Connection();
        Connection conec = Conexion.getCnnection();
        Statement st;
        String sql = "UPDATE VENDEDORES SET NOMBRE ='" + v.getNombre() + "', SUCURSAL='" + v.getSucursal() + "', CORREO ='" + v.getCorreo() + "' where IDENTIFICACION = '" + v.getIdentificacion() + "'";
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
        String sql = "DELETE FROM VENDEDORES  WHERE IDENTIFICACION'" + Identificacion + "'";

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
