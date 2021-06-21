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
public class MecanicoDTO extends EmpleadoDTO {

    String especialidad;

    public MecanicoDTO(String apellido, String nombre, String tipoDNI, String nroDNI, 
                       String telefono, int legajo, String area, String especialidad) {
        super(apellido, nombre, tipoDNI, nroDNI, telefono, legajo, area);
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
