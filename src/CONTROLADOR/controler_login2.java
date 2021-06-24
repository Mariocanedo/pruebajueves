/*

 */
package CONTROLADOR;

import MODELO.Usuario;
import Modelo.DAOPersona;
import Modelo.Empleado.DAOEmpleado;
import Modelo.Empleado.Empleado;
import VISTA.LOGIN2;
import Vista.VistaEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC1
 */
public class controler_login2 implements ActionListener {

    private LOGIN2 login;
    private Usuario usu;
    private DAOPersona dao;

    public controler_login2(LOGIN2 login, Usuario usu, DAOPersona dao) {
        this.login = login;
        this.usu = usu;
        this.dao = dao;
        this.login.ingresar.addActionListener(this);

    }

    public void iniciar() {
        login.setTitle("LOGIN");
        //viewLog.setSize(new Dimension(800, 600));
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        //UIManager.setLookAndFeel(new McWinLookAndFeel());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (login.ingresar == ae.getSource()) {

            usu.setRut(login.txt_rut.getText());
            usu.setNombre(login.txt_nombre.getText());
            if (dao.validarUsuario(usu)) {
                try {
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

                } catch (SQLException ex) {
                    Logger.getLogger(controler_login2.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete los camposS");
        }
    }

}//fin actionPerformed

