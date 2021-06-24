/*
 Implementa operaciones de la base de datos
 */
package Modelo.Empleado;

import Modelo.Persona;
import Modelo.conecc;
import Modelo.operaciones;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class DAOEmpleado implements operaciones {

    Empleado em = new Empleado();
    conecc conectar = conecc.getInstance();

    Connection con;

    @Override
    public boolean Agregar(Object obj) {
        em = (Empleado) obj;
        String sql = "INSERT INTO empleado (Nombre_empleado,Apellido_empleado,id_categoria ) VALUES (?,?,(select  id_categoria FROM categoria where descripcion_categoria =?))";
        PreparedStatement pst;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, em.getNombre());
            pst.setString(2, em.getApellido());
            pst.setString(3, em.getCategoria_empleado());
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
        em = (Empleado) obj;
        String sql = "UPDATE  empleado  set Nombre_empleado=?, Apellido_empleado =?, id_categoria=(select  id_categoria FROM categoria ID where descripcion_categoria =? ) where id_empleado =?";

        PreparedStatement pst;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, em.getNombre());
            pst.setString(2, em.getApellido());
            pst.setString(3, em.getCategoria_empleado());
            pst.setInt(4, em.getId_empleado());
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
    public boolean Eliminar(Object obj) {
        em = (Empleado) obj;
        String sql = "DELETE     FROM  empleado   where id_empleado =?";
        PreparedStatement pst;
        try {
            con = (Connection) conectar.getConection();
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, em.getId_empleado());
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
    public ArrayList<Object[]> consultar() {
        // select  * from empleado.
        String sql = " select  e.id_empleado, e.Nombre_empleado, e.Apellido_empleado, c.descripcion_categoria  \n"
                + " from categoria c INNER JOIN empleado e\n"
                + "on c.id_categoria  = e.id_categoria";
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

    /////////////////////////////////////////// METODO PARA OBTENER DATOS 
    public DefaultComboBoxModel ob_Cate() throws SQLException {
        con = (Connection) conectar.getConection();
        Statement st = con.createStatement();
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Seleccione una Categoria");
        ResultSet rs = st.executeQuery("Select descripcion_categoria from categoria");

        try {
            while (rs.next()) {
                ListaModelo.addElement(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un errror" + ex.getMessage());
        }
        return ListaModelo;

    }

    @Override
    public boolean validarUsuario(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
