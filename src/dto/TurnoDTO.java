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
public class TurnoDTO {
    private int nroTurno;
    private String anoMes;
    private int legajoMecanico;
    private int nroPoliza;
    private String dia;
    private String hora;
    private int nroTitular;
    private String cuitCompania;
    private String estado;
    private int nroFicha;
    
    public TurnoDTO(int nroTurno, String anoMes, int legajoMecanico, int nroPoliza, 
                    String dia, String hora, int nroTitular, String cuitCompania,
                    String estado, int nroFicha) {

        this.anoMes = anoMes;
        this.nroTurno = nroTurno;
        this.dia = dia;
        this.hora = hora;
        this.legajoMecanico = legajoMecanico;
        this.nroPoliza = nroPoliza;
        this.nroTitular = nroTitular;
        this.cuitCompania = cuitCompania;
        this.estado = estado;
        this.nroFicha = nroFicha;

    }

    public int getNroTurno() {
        return nroTurno;
    }

    public void setNroTurno(int nroTurno) {
        this.nroTurno = nroTurno;
    }

    public String getAnoMes() {
        return anoMes;
    }

    public void setAnoMes(String anoMes) {
        this.anoMes = anoMes;
    }

    public int getLegajoMecanico() {
        return legajoMecanico;
    }

    public void setLegajoMecanico(int legajoMecanico) {
        this.legajoMecanico = legajoMecanico;
    }

    public int getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(int nroPoliza) {
        this.nroPoliza = nroPoliza;
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

    public int getNroTitular() {
        return nroTitular;
    }

    public void setNroTitular(int nroTitular) {
        this.nroTitular = nroTitular;
    }

    public String getCuitCompania() {
        return cuitCompania;
    }

    public void setCuitCompania(String cuitCompania) {
        this.cuitCompania = cuitCompania;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }    
}
    