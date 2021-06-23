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
    private int id;
    private String dia;
    private String horario;
    private String mecanico;
    private String estado;

    public AgendaDTO(int id, String dia, String horario, String mecanico, String estado) {
        this.id = id;
        this.dia = dia;
        this.horario = horario;
        this.mecanico = mecanico;
        this.estado = estado;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }
    
    /**
     * @return the dia
     */
    public String getHorario() {
        return horario;
    }
    
       /**
     * @return the dia
     */
    public String getEstado() {
        return estado;
    }

     /**
     * @return the dia
     */
    public String getMecanico() {
        return mecanico;
    }
    
}
