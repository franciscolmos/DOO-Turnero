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
public class AgendaDTO {
    private String dia;
    private String horario;
    private String mecanico;
    private String estado;

    public AgendaDTO(String dia, String horario, String mecanico, String estado) {
        this.dia = dia;
        this.horario = horario;
        this.mecanico = mecanico;
        this.estado = estado;
    }
    
      /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    
       /**
     * @return the dia
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param dia the dia to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
       /**
     * @return the dia
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param dia the dia to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     /**
     * @return the dia
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * @param dia the dia to set
     */
    public void setMecanico(String estado) {
        this.mecanico = mecanico;
    }
     
}
