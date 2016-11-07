
package Modelo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    Conexion MySql;
    private static final String server = "jdbc:sqlserver://localhost:1433;databaseName=WORLDCAD"; //Aquí colocaremos la ruta de nuestra base de datos;
    private static final String user = "sa"; //Aquí colocaremos el nombre de usuario mySql;
    private static final String pass = "Worldcad"; //Aquí colocaremos la clave de acceso de usuario a mySql;
    private static final Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver(); //Aquí colocaremos muestra librería mySql;
    private static Connection conexion; //Creamos un objeto de clase Connection para la conexión para la conexión;

    /*//Conecion SQL Server
    private static String server = "jdbc:sqlserver://localhost:1433;databaseName=TarjetaCredito";; //Aquí colocaremos la ruta de nuestra base de datos;
    private static String user = "sa"; //Aquí colocaremos el nombre de usuario mySql;
    private static String pass = "Goofy2005*"; //Aquí colocaremos la clave de acceso de usuario a mySql;
    private static final Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver(); //Aquí colocaremos muestra librería mySql;
    private static Connection conexion; //Creamos un objeto de clase Connection para la conexión para la conexión;*/
    
    public static void Connection() {
        try{
            //Class.forName(driver);  //Levanta el driver que se pasa por argumento 
            //conexion= DriverManager.getConnection(server,user,pass); //Con el objeto Conecction obtengo la conexión por medio
            //del método estático getConnection de la clase DriverManager, pasándole por argumentos el Servidor, 
            //el Usuario y el Password:
            
            DriverManager.registerDriver(driver);
            conexion = DriverManager.getConnection(server, user, pass);
            
        /*}catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex, "Error 1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;*/
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error 2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error 3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        
   }
   
   //Método para obtener el objeto de la clase Connection con la conexión establecida:
   public static Connection getCnnection(){
       return conexion; 
   } 
}
class Main {
    public static void main(String[] args){
        Conexion.Connection();
        if(Conexion.getCnnection() != null){
            JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
        }
    }
}
