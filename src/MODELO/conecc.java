/*
Representa clase de conexion. Esta basada el patron singleton
Tiene variables privadas estatica y un metodo estatico que resumen todo el patron
Patron singleton una unica instancia de conexion
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conecc {
    
     private static final String url = "jdbc:mysql://localhost:3306/per";
    private static final String user = "root";
    private static final String pass = "12345";
    private static Connection con;
    private static  conecc instancia;
    
    private conecc(){}
    
    
    // constructor  metodo conectar
    public Connection getConection(){
    Connection con =null;
    try {
    Class.forName("com.mysql.jdbc.Driver");
    con = (Connection) DriverManager.getConnection(url,user,pass);
      //   JOptionPane.showMessageDialog(null, "Conexion exitosa");
    return con;
    
    }catch( ClassNotFoundException |SQLException e){
   JOptionPane.showMessageDialog(null, "Error" +e);

    } 
    return con;
    
    }
      
    //metodo desconectar
    public void cerrarConecxion(){
    try{
        con.close();
          JOptionPane.showMessageDialog(null, "Desconexion exitosa");

    }catch(Exception e ){
      JOptionPane.showMessageDialog(null, "Error" +e);
    }
    }
 //metodo patron singleton
    
     public  static conecc getInstance(){
        if (instancia==null){
            instancia = new conecc();
        }
        return instancia;
       } // fin getConnection
}
