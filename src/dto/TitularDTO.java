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
    
    private int nroTitular;
   
    public TitularDTO(int nroTitular, String tipoDNI, String nroDNI, String nombre, String apellido, String telefono) {
        super(apellido, nombre, tipoDNI, nroDNI, telefono);
    }

    public int getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(int nroTitular) {
        this.nroTitular = nroTitular;
    }
}
