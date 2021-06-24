/*
 clase  3 Representa las accione de la base de datos
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author PC1
 */
public interface operaciones {
    
    public boolean Agregar(Object obj);
       public boolean Modificar(Object obj);
       public boolean Eliminar(Object obj);
      public ArrayList<Object[]>consultar();
         public boolean validarUsuario(Object obj);

}