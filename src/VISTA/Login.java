/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;


import CONTROLADOR.Controler_login;
import MODELO.Usuario;
import Modelo.DAOPersona;
import Modelo.conecc;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC1
 */
public class Login extends javax.swing.JFrame {

    conecc conectar = conecc.getInstance();
    Connection con;
    
    public Login() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_rut = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ingresar.setBackground(new java.awt.Color(204, 255, 0));
        ingresar.setText("INGRESAR");
        ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ingresar.setBorderPainted(false);
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_rut)
                    .addComponent(txt_nombre)
                    .addComponent(ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
       
        
    }//GEN-LAST:event_ingresarActionPerformed

  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
    

    Login vista = new Login();
    DAOPersona  dao = new DAOPersona ();
  
   // Instancia del Controlador
        Controler_login ctr = new Controler_login (vista,dao) {};
        // metodo del controlador
        ctr.iniciar();
        vista.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ingresar;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
