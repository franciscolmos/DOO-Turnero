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
public class FichaMecanicaDTO {
    int nroFicha;
    int legajoMecanico;
    String estado;
    String observaciones;
    
    public FichaMecanicaDTO(int nroFicha, int legajoMecanico, String estado, 
                            String observaciones) {
        this.nroFicha = nroFicha;
        this.legajoMecanico = legajoMecanico;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    public int getLegajoMecanico() {
        return legajoMecanico;
    }

    public void setLegajoMecanico(int legajoMecanico) {
        this.legajoMecanico = legajoMecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
