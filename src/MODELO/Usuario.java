/*
Esta Clase es Para validar Login
 */
package MODELO;


public class Usuario {
    private String Rut;
    private String Nombre;

    // constructor vacio
    public Usuario(){
    Rut="";
    Nombre ="";
    }
    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
