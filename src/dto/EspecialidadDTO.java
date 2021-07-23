/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author francisco
 */
public class EspecialidadDTO {
    private String codEspecialidad;
    private String nombre;
    private String descripcion;

    public EspecialidadDTO(String codEspecialidad, String nombre, String descripcion) {
        this.codEspecialidad = codEspecialidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodEspecialidad() {
        return codEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodEspecialidad(String codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
