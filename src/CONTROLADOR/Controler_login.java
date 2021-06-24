/*

 */
package CONTROLADOR;

import MODELO.Usuario;
import Modelo.DAOPersona;
import Modelo.Empleado.DAOEmpleado;
import Modelo.Empleado.Empleado;
import VISTA.Login;
import Vista.VistaEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controler_login implements ActionListener {
   
        private Login vista;
        // tiene metodo  validar 
        private DAOPersona dao;
   
         
    // Metodo iniciar componentes
    public Controler_login(Login vista,DAOPersona dao){
        this.dao=dao;
        this.vista = vista;
        this.vista.ingresar.addActionListener(this);
    }
    
    // iniciar Vista ()
    public void iniciar() throws SQLException {
        vista.setTitle("Login");// establece titulo de la ventana
        vista.setLocationRelativeTo(null);
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if (e.getSource() == vista.ingresar) {
                String Rut = vista.txt_rut.getText();
                String Nombre= vista.txt_nombre.getText();
                dao.Login(Rut, Nombre);
              try{
              if(dao.Login(Rut, Nombre) == true){
                  JOptionPane.showMessageDialog(null, "Validacion de usuario exitosa");
                //CONSTRUCTOR DEL CONTROLER DE LA VENTANA QUE ESTAMOS LLAMANDO
                    Empleado em = new Empleado();
                    DAOEmpleado dao = new DAOEmpleado();
                    VistaEmpleado vista = new VistaEmpleado();
                    // Instancia del Controlador
                    ControladorEmpleado ctr = new ControladorEmpleado(em, dao, vista);
                    // metodo del controlador 
                    ctr.iniciar();
                    VistaEmpleado Em = new VistaEmpleado();
                    vista.setVisible(true);
              
              }
              
              
              }catch(Exception f ){
                    JOptionPane.showMessageDialog(null, "Algo Salio Mal"+f);
              }       }
    }
    
}
