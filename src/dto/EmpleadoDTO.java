/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author felipe
 */
public abstract class EmpleadoDTO extends PersonaDTO {
    
    int legajo;
    String area;
    
    public EmpleadoDTO(String apellido, String nombre, String tipoDNI, 
                       String nroDNI, String telefono, int legajo, String area) {
        super(apellido, nombre, tipoDNI, nroDNI, telefono);
        this.legajo = legajo;
        this.area = area;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getArea() {
        return area;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
