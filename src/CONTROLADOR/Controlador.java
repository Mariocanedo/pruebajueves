/*
Clase Controlador. implementa vista y clase dao
 */
package CONTROLADOR;

import Modelo.DAOPersona;
import Modelo.Persona;
import Vista.VistaPersona;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// IMPLEMENTO ACTION LISTENER ESCUCHADOR
public class Controlador implements ActionListener, MouseListener {

    // IMPORTA LAS CLASES
    private Persona per;
    private DAOPersona dao;
    private VistaPersona vista;

    String[] columnas = {"id", "rut", "Nombre", "Apellidos"};
    ArrayList<Object[]> datos = new ArrayList<>();
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    public Controlador(Persona per, DAOPersona dao, VistaPersona vista) {
        this.per = per;
        this.dao = dao;
        this.vista = vista;
        this.vista.btnguardar.addActionListener(this);
        this.vista.btnactualizar.addActionListener(this);
        this.vista.btneliminar.addActionListener(this);
                vista.table1.addMouseListener(this);
  
    }

// iniciar Vista ()
    public void iniciar() {
        vista.setTitle("Personas");// establece titulo de la ventana
        vista.setLocationRelativeTo(null);
        vista.txt_id.enable(false);
        cargar();
        // ESCUCHADOR 

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // detectar que boton presiona  +++GUARDAR  ++
        if (e.getSource() == vista.btnguardar) {
            per.setRut(Integer.parseInt(vista.txt_rut.getText()));
            per.setNombre(vista.txt_nombre.getText());
            per.setApellidos(vista.txt_apellido.getText());
            if (dao.Agregar(per)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        // detectar btn Modificar
        if (e.getSource() == vista.btnactualizar) {

            per.setId(Integer.parseInt(vista.txt_id.getText()));
            per.setRut(Integer.parseInt(vista.txt_rut.getText()));
            per.setNombre(vista.txt_nombre.getText());
            per.setApellidos(vista.txt_apellido.getText());

            if (dao.Modificar(per)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        // btn eliminar 
        if (e.getSource() == vista.btneliminar) {
            per.setId(Integer.parseInt(vista.txt_id.getText()));
            if (dao.Eliminar(per)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar r");
                limpiar();
            }
        }
    }

    // evento Limpiar 
    public void limpiar() {
        vista.txt_id.setText(null);
        vista.txt_rut.setText(null);
        vista.txt_nombre.setText(null);
        vista.txt_apellido.setText(null);
    }

    public void cargar() {
        modelo.setRowCount(0);
        datos = dao.consultar();
        // for each
        for (Object[] obj : datos) {
            modelo.addRow(obj);
        }
        vista.table1.setModel(modelo);

    }

    // implementacion de tabla
    @Override
    public void mouseClicked(MouseEvent me) {
        // LO QUE SELECCION SE CARGAR JTEXB

        if (me.getSource() == vista.table1) {
            vista.txt_id.setText(String.valueOf(vista.table1.getValueAt(vista.table1.getSelectedRow(), 0)));
            vista.txt_rut.setText(String.valueOf(vista.table1.getValueAt(vista.table1.getSelectedRow(), 1)));
            vista.txt_nombre.setText(String.valueOf(vista.table1.getValueAt(vista.table1.getSelectedRow(), 2)));
            vista.txt_apellido.setText(String.valueOf(vista.table1.getValueAt(vista.table1.getSelectedRow(), 3)));
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}     // cierre de la clase

