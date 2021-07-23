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

    String codEspecialidad;

    public MecanicoDTO(String apellido, String nombre, String tipoDNI, String nroDNI, 
                       String telefono, int legajo, String area, String codEspecialidad) {
        super(apellido, nombre, tipoDNI, nroDNI, telefono, legajo, area);
        this.codEspecialidad = codEspecialidad;
    }
    
    public String getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(String codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

}
