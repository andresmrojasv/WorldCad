                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo_Garcia
 */
public class CotizacionesDAO {

    int ProxNumCot;

    public void registrarCotizacion(Cotizaciones cotiza, ArrayList detalle, double subtotal, double iva, double total) {
        ArrayList<DetalleCotizacion> productos = new ArrayList();
        productos = detalle;
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        //fecha.format(now)
        //System.out.println(fechacierre.format(now));
        //System.out.println(""+cotiza.getFechaEstCierre());
        String numCotiza = calNumCotiza();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection(); //Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BBDD
        //Creamos la sentencia SQL
        String sql = "INSERT INTO COTIZACIONES (CLIENTES_ID,VENDEDORES_ID,FECHA_CREACION, FECHA_EST_CIERRE,PORCENTAJE_CIERRE,DESCRIPCION, NUMERO_COTIZACION,IDENTIFICACION_COTIZACION,SUBTOTAL,IVA,TOTAL) values ((SELECT CLIENTES_ID FROM CLIENTES WHERE NOMBRE_EMPRESA= '" + cotiza.getCliente() + "'),(SELECT VENDEDORES_ID FROM VENDEDORES WHERE NOMBRE = '" + cotiza.getVendedor() + "'),'"+fecha.format(now)+"','"+cotiza.getFechaEstCierre()+"','" + cotiza.getPorcentajecierre() + "','" + cotiza.getDescripcion() + "','" + numCotiza + "','" + ProxNumCot + "','" + subtotal + "','" + iva + "','" + total + "')";

        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la cotización");
        }
        int conteo = productos.size();
        for (DetalleCotizacion pro : productos) {
            conteo = conteo - 1;
            String sql2 = "INSERT INTO DETALLE_COTIZACIONES (COTIZACIONES_ID,PRODUCTOS_ID,CANTIDAD,PRECIO_UNITARIO,PRECIO_TOTAL) VALUES ((SELECT COTIZACIONES_ID FROM COTIZACIONES WHERE IDENTIFICACION_COTIZACION= '" + ProxNumCot + "'),(SELECT PRODUCTOS_ID FROM PRODUCTOS WHERE NUMERO_PARTE='" + pro.getNumParte() + "'),'" + pro.getCantidad() + "','" + pro.getPrecioVenta() + "','" + pro.getPrecioTotal() + "')";
           
            try {
                st = conn.createStatement();
                st.executeUpdate(sql2);

                if (conteo == 0) {
                    //Cerramos conexiones
                    conn.close();
                    st.close();
                    JOptionPane.showMessageDialog(null, "Se ha registrado la cotización Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "No se Registro el prodcuto \n");
            }
            
        }

    }

    public void modificarCotizacion(Cotizaciones cotiza, ArrayList modicotiza, double subtotal, double iva, double total, String numcotiza) {
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st; //Para ejecutar sentecias SQL y enviarlas a las BD

        //Creamos la sentencia SQL
        String sql = "UPDATE COTIZACIONES SET FECHA_EST_CIERRE='"+cotiza.getFechaEstCierre()+"', PORCENTAJE_CIERRE='"+cotiza.getPorcentajecierre()+"', DESCRIPCION='"+cotiza.getDescripcion()+"',CLIENTES_ID=(SELECT CLIENTES_ID FROM CLIENTES WHERE NOMBRE_EMPRESA='"+cotiza.getCliente()+"'),VENDEDORES_ID=(SELECT VENDEDORES_ID FROM VENDEDORES WHERE NOMBRE = '"+cotiza.getVendedor()+"'),SUBTOTAL='"+subtotal+"', IVA='"+iva+"',TOTAL='"+total+"' WHERE NUMERO_COTIZACION='"+numcotiza+"'";
        System.out.println(""+sql);
        //Ejecuta la sentencia SQL
        try {
            st = conn.createStatement();
            int confirmar = st.executeUpdate(sql);
            if (confirmar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado la cotización exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar la cotización");
            }

            //Cerramos conexiones
            conn.close();
            st.close();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }

    }

    public ArrayList<Cotizaciones> consultarCotizacion(String numCotizacion) {
        ArrayList cotizacion = new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta

        //Creamos la sentencia SQL
        String sql = "SELECT  CLIENTES.NOMBRE_EMPRESA,VENDEDORES.NOMBRE,COTIZACIONES.FECHA_EST_CIERRE,COTIZACIONES.PORCENTAJE_CIERRE,COTIZACIONES.DESCRIPCION,COTIZACIONES.NUMERO_COTIZACION FROM COTIZACIONES,VENDEDORES,PRODUCTOS,CLIENTES WHERE (COTIZACIONES.CLIENTES_ID=CLIENTES.CLIENTES_ID) AND (COTIZACIONES.VENDEDORES_ID= VENDEDORES.VENDEDORES_ID)  AND (NUMERO_COTIZACION='"+numCotizacion+"')";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            if (rs.next()) {
                Cotizaciones Cotiza = new Cotizaciones();
                Cotiza.setCliente(rs.getString("NOMBRE_EMPRESA"));
                Cotiza.setVendedor(rs.getString("NOMBRE"));
                Cotiza.setFechaEstCierre(rs.getString("FECHA_EST_CIERRE"));
                Cotiza.setPorcentajecierre((rs.getDouble("PORCENTAJE_CIERRE")));
                Cotiza.setDescripcion(rs.getString("DESCRIPCION"));
                Cotiza.setNumCotizacion(rs.getString("NUMERO_COTIZACION"));
                cotizacion.add(Cotiza);
            }
            //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n" + e);
        }
        return cotizacion;
    }
    public ArrayList<DetalleCotizacion> consultarDetalleCotizacion(String numCotizacion) {
        ArrayList detalleCotizacion = new ArrayList();
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta

        //Creamos la sentencia SQL
        String sql = "SELECT  DETALLE_COTIZACIONES.CANTIDAD,PRODUCTOS.NOMBRE,PRODUCTOS.NUMERO_PARTE,DETALLE_COTIZACIONES.PRECIO_UNITARIO,DETALLE_COTIZACIONES.PRECIO_TOTAL,COTIZACIONES.SUBTOTAL,COTIZACIONES.IVA,COTIZACIONES.TOTAL FROM COTIZACIONES,DETALLE_COTIZACIONES,PRODUCTOS WHERE (DETALLE_COTIZACIONES.COTIZACIONES_ID=COTIZACIONES.COTIZACIONES_ID)  AND (DETALLE_COTIZACIONES.PRODUCTOS_ID= PRODUCTOS.PRODUCTOS_ID) AND (NUMERO_COTIZACION='"+numCotizacion+"')";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            
            while (rs.next()) {
                DetalleCotizacion dc = new DetalleCotizacion();
                dc.setCantidad(rs.getInt("CANTIDAD"));
                dc.setNumParte(rs.getString("NUMERO_PARTE"));
                dc.setProducto(rs.getString("NOMBRE"));
                dc.setPrecioVenta(rs.getDouble("PRECIO_UNITARIO"));
                dc.setPrecioTotal(rs.getDouble("PRECIO_TOTAL"));
                dc.setSubTotal(rs.getDouble("SUBTOTAL"));
                dc.setIva(rs.getDouble("IVA"));
                dc.setTotal(rs.getDouble("TOTAL"));

                detalleCotizacion.add(dc);
            }
            //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Contacto\n" + e);
        }
        return detalleCotizacion;
    }

    public String calNumCotiza() {
        String numCotiza = "";
        //Conexion y carga BD
        Conexion.Connection();
        Connection conn = Conexion.getCnnection();//Para establecer conexiones con las bases de datos
        Statement st;//Para ejecutar sentecias SQL y enviarlas a las BBDD
        ResultSet rs; //Para almacenar el resultado de la consulta

        //Creamos la sentencia SQL
        String sql = "SELECT TOP 1 IDENTIFICACION_COTIZACION FROM COTIZACIONES ORDER BY IDENTIFICACION_COTIZACION DESC";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Extraer los datos d ela consulta
            if (rs.next() == true) {

                ProxNumCot = rs.getInt("IDENTIFICACION_COTIZACION");
                ProxNumCot = ProxNumCot + 1;
                numCotiza = "PV-" + (ProxNumCot);

            } else {
                numCotiza = "PV-1";
                ProxNumCot = 1;
            }
            //Cerramos conexiones
            conn.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n" + e);
        }
        return numCotiza;

    }

}