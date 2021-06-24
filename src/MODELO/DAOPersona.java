/*
Operaciones De la base de datos CRUD IMPLEMENTA MÉTODOS DE LA INTERFAZ
 */
package Modelo;

import MODELO.Usuario;
import VISTA.Login;
import Vista.VistaEmpleado;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static com.sun.glass.ui.Cursor.setVisible;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOPersona implements operaciones {

    Persona pe = new Persona();
    Usuario us = new Usuario();
    //patron singleton
    conecc conectar = conecc.getInstance();
    Connection con;

    @Override
    public boolean Agregar(Object obj) {
        pe = (Persona) obj;
        String sql = "INSERT INTO persona (Rut,Nombre,Apellidos) VALUES(?,?,?)";
        PreparedStatement pst;

        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, pe.getRut());
            pst.setString(2, pe.getNombre());
            pst.setString(3, pe.getApellidos());
            int filas = pst.executeUpdate();
            if (filas > 0) {

                con.close();
                return true;
            } else {

                con.close();
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror : " + e.getMessage());
        }
        return false;

    }

    @Override
    public boolean Modificar(Object obj) {

        pe = (Persona) obj;
        String sql = "UPDATE  persona SET Rut =?,Nombre = ?,Apellidos =?  WHERE Id =?";
        Connection con;
        PreparedStatement pst;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);

            pst.setInt(1, pe.getRut());
            pst.setString(2, pe.getNombre());
            pst.setString(3, pe.getApellidos());
            pst.setInt(4, pe.getId());
            int filas = pst.executeUpdate();
            if (filas > 0) {
                con.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean Eliminar(Object obj) {
        pe = (Persona) obj;
        String sql = "DELETE FROM persona where Id=?";
        Connection con;
        PreparedStatement pst;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);

            pst.setInt(1, pe.getId());
            int filas = pst.executeUpdate();
            con.close();
            if (filas > 0) {
                con.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror :" + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> consultar() {
        String sql = "SELECT  * FROM persona";
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData meta;
        ArrayList<Object[]> datos = new ArrayList<>();

        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);

            rs = pst.executeQuery();
            meta = rs.getMetaData();
            while (rs.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                datos.add(fila);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror" + e.getMessage());

        }
        return datos;
    }

  

// ESTE MÉTODO FUNCIONA!!!!! CON UNA CLASE USUARIO TRATAMOS TODO COMO OBJETO

    @Override
    public boolean validarUsuario(Object obj) {
        Usuario usu = new Usuario();
        usu = (Usuario) obj;
        String sql = "SELECT * FROM persona WHERE Rut = ? AND Nombre = ?";
        java.sql.Connection con;
        java.sql.PreparedStatement pst;
        ResultSet rs;
        boolean Valido = false;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
// ocupamos get and set
            pst.setString(1, usu.getRut());
            pst.setString(2, usu.getNombre());

            rs = pst.executeQuery();

            while (rs.next()) {
               Valido = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror" + e.getMessage());

        }
        return Valido;

    }




    public boolean Login(String rut,String nombre) {
        boolean usuarioValido = false;
          java.sql.Connection con = null;
        java.sql.PreparedStatement pst;
        ResultSet rs;
        //  ArrayList list = new ArrayList ();
        String sql = "SELECT * from persona  WHERE Rut = ' " + rut+ " ' AND  Nombre = ' " + nombre + " ' ";
 
        try {
             //   pst = (PreparedStatement) con.createStatement();
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
            
            pst.setString(1, rut);
            pst.setString(2, nombre);
             rs = pst.executeQuery(sql);
           if (rs.next()) {
                usuarioValido = true;
                if(usuarioValido== true){
                 JOptionPane.showMessageDialog(null, "Datos Correctos");
            }}
           else{
           usuarioValido= false;
           JOptionPane.showMessageDialog(null, "Datos incorrectos");
                       }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror" + e.getMessage());

        }
        return usuarioValido;
    }

}
