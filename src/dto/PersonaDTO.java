/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author benja
 */
public abstract class PersonaDTO {
    private String apellido;
    private String nombre;
    private String tipoDNI;
    private String nroDNI;
    private String telefono;
    
    public PersonaDTO(String apellido, String nombre, String tipoDNI, String nroDNI, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoDNI = tipoDNI;
        this.nroDNI = nroDNI;
        this.telefono = telefono;
    }
    
    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getTipoDNI() {
        return tipoDNI;
    }

    public void setTipoDNI(String tipoDNI) {
        this.tipoDNI = tipoDNI;
    }

    /**
     * @return the sexo
     */
    public String getNroDNI() {
        return nroDNI;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setNroDNI(String nroDNI) {
        this.nroDNI = nroDNI;
    }

    /**
     * @return the legajo
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
