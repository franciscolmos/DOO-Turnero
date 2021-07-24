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
    private String ano_mes;
    private int legajo_mecanico;
    private String dia;
    private String hora;
    private String estado;

    public AgendaDTO(String ano_mes, int legajo_mecanico, String ... opcionales) {
        this.legajo_mecanico = legajo_mecanico;
        this.ano_mes = ano_mes;
        this.dia =  opcionales.length > 0 ? opcionales[0] : "";
        this.hora = opcionales.length > 1 ? opcionales[1] : "";
        this.estado = opcionales.length > 2 ? opcionales[2] : "";
    }
    
    /**
     * @return the id
     */
    public int getLegajo_mecanico() {
        return legajo_mecanico;
    }
    
    /**
     * @return the dia
     */
    public String getAno_mes() {
        return ano_mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
