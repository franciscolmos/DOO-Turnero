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
public class TitularDTO extends PersonaDTO{
    
   private String compania;
   
    public TitularDTO(String nombre, String apellido, String tipoDNI, String nroDNI, String telefono,String compania) {
        super(apellido, nombre, tipoDNI, nroDNI, telefono);
        this.compania = compania;
    }

    /**
     * @return the compania
     */
    public String getCompania() {
        return compania;
    }

    /**
     * @param comapnia the compania to set
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }
}
