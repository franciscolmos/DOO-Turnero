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
public abstract class Empleado extends Persona{
    
    public Empleado(String nombre, String apellido, String tipoDNI, String nroDNI, String direccion, String email, int telefono, int edad) {
        super(nombre, apellido, tipoDNI, nroDNI, direccion, email, telefono, edad);
    }
    
}
