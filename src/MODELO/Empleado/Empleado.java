/*
Representa tabla empleado que esta relacionada con otra tabla categoria
 */
package Modelo.Empleado;

public class Empleado {

    private int id_empleado;
    private String nombre;
    private String apellido;
    // es un string y en la consulta captamos el id
    private String Categoria_empleado;
    
    
// contructor por defecto vacio
    public Empleado() {
    }

    ;

    public String getCategoria_empleado() {
        return Categoria_empleado;
    }

    public void setCategoria_empleado(String Categoria_empleado) {
        this.Categoria_empleado = Categoria_empleado;
    }
  

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

 

}
