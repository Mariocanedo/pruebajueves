package CONTROLADOR;

import Modelo.DAOPersona;
import Modelo.Empleado.DAOEmpleado;
import Modelo.Empleado.Empleado;
import Modelo.Persona;
import Vista.VistaEmpleado;
import Vista.VistaPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*controlador de vista Empleado*/

 /*implentamos eventos para captar btn y eventos de la tabla*/
public class ControladorEmpleado implements ActionListener, MouseListener {

    // IMPORTA LAS CLASES
    private Empleado em;
    private DAOEmpleado dao;
    private VistaEmpleado vista;

    String[] columnas = {"id", "rut", "Nombre", "Departamento"};
    ArrayList<Object[]> datos = new ArrayList<>();
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    public ControladorEmpleado(Empleado em, DAOEmpleado dao, VistaEmpleado vista) {
        this.em = em;
        this.dao = dao;
        this.vista = vista;
        this.vista.btnagregar.addActionListener(this);
        this.vista.btnactualizar.addActionListener(this);
        this.vista.btneliminar.addActionListener(this);
    }

// iniciar Vista ()
    public void iniciar() throws SQLException {
        vista.setTitle("Empleados");// establece titulo de la ventana
        vista.setLocationRelativeTo(null);
        vista.txt_id.enable(false);
        cargar();
           // ESCUCHADOR TABLE PARA EVENTOS
           vista.table2.addMouseListener(this);
           vista.combocate.setModel(dao.ob_Cate());
    }

    @Override
    //evento de btn agregar, eliminar, actualizar.
    public void actionPerformed(ActionEvent e) {
        
          // detectar que boton presiona  +++GUARDAR  ++
        if (e.getSource() == vista.btnagregar) {
            em.setNombre(vista.txt_nombre.getText());
            em.setApellido(vista.txt_apellido.getText());
             em.setCategoria_empleado(vista.combocate.getSelectedItem().toString());
            if (dao.Agregar(em)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
      // detectar que boton presiona  +++Actualizar  ++
        if (e.getSource() == vista.btnactualizar) {
              em.setId_empleado(Integer.parseInt(vista.txt_id.getText()));
            em.setNombre(vista.txt_nombre.getText());
            em.setApellido(vista.txt_apellido.getText());
               
           //String itemSeleccionado =(String)vista.combocate.getSelectedItem().toString();
            // em.setCategoria_empleado(itemSeleccionado);
            
             em.setCategoria_empleado(vista.combocate.getSelectedItem().toString());
            if (dao.Modificar(em)) {
                JOptionPane.showMessageDialog(null, "Actualizado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
                limpiar();
            }
        }
        
              // detectar que boton presiona  +++Eliminar  ++
        if (e.getSource() == vista.btneliminar) {
            em.setId_empleado(Integer.parseInt(vista.txt_id.getText()));
            if (dao.Eliminar(em)) {
                JOptionPane.showMessageDialog(null, "Eliminado");
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    
           if (me.getSource() == vista.table2) {
            vista.txt_id.setText(String.valueOf(vista.table2.getValueAt(vista.table2.getSelectedRow(), 0)));
              vista.txt_nombre.setText(String.valueOf(vista.table2.getValueAt(vista.table2.getSelectedRow(), 1)));
                  vista.txt_apellido.setText(String.valueOf(vista.table2.getValueAt(vista.table2.getSelectedRow(), 2)));
                 vista.combocate.setSelectedItem(String.valueOf(vista.table2.getValueAt(vista.table2.getSelectedRow(), 3)));
                 
        
    }}

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
    
    
    
        // evento Limpiar 
    public void limpiar() {
        vista.txt_id.setText(null);
        vista.txt_nombre.setText(null);
        vista.txt_apellido.setText(null);
        vista.combocate.setSelectedIndex(0);
    }

    public void cargar() {
        modelo.setRowCount(0);
        datos = dao.consultar();
        // for each
        for (Object[] obj : datos) {
            modelo.addRow(obj);
        }
        vista.table2.setModel(modelo);

    }

}
