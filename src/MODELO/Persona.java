/*
Clase NUMERO 2 , REPRESENTA LA TABLA DE LA BASE DE DATOS CON SUS ATRIBUTOS Y GETERS AND SETERS
 */
package Modelo;


public class Persona {
    
// atributos 
    private int id;
    private int rut;
       private String Nombre;
     private String Apellidos;
     
     public Persona(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
  
    
}
