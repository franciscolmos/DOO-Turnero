/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author francisco
 */
public abstract class Persona {
    String nombre;
    String apellido;
    String tipoDNI;
    String nroDNI;
    String direccion;
    String email;
    int telefono;
    int edad;

    public Persona(String nombre, String apellido, String tipoDNI, String nroDNI, String direccion, String email, int telefono, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDNI = tipoDNI;
        this.nroDNI = nroDNI;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoDNI() {
        return tipoDNI;
    }

    public String getNroDNI() {
        return nroDNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipoDNI(String tipoDNI) {
        this.tipoDNI = tipoDNI;
    }

    public void setNroDNI(String nroDNI) {
        this.nroDNI = nroDNI;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre +
                            ", apellido=" + apellido +
                            ", tipoDNI=" + tipoDNI + 
                            ", nroDNI=" + nroDNI + 
                            ", direccion=" + direccion + 
                            ", email=" + email + 
                            ", telefono=" + telefono + 
                            ", edad=" + edad + '}';
    }
    
    
}
