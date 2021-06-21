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
    private int nro;
    private String dia;
    private String hora;
    private String mecanico;
    private String vehiculo;
    private String titular;
    private String companiaSeguro;
    private String estado;
    private String fichaMecanica;
    
    public TurnoDTO(int nro, String dia, String hora, String mecanico, 
                    String vehiculo, String titular, String companiaSeguro,
                    String estado, String fichaMecanica) {
    this.nro = nro;
    this.dia = dia;
    this.hora = hora;
    this.mecanico = mecanico;
    this.vehiculo = vehiculo;
    this.titular = titular;
    this.companiaSeguro = companiaSeguro;
    this.estado = estado;
    this.fichaMecanica = fichaMecanica;
    }
    
    /*
    ---SETTERS
    */
    
    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setCompaniaSeguro(String companiaSeguro) {
        this.companiaSeguro = companiaSeguro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFichaMecanica(String fichaMecanica) {
        this.fichaMecanica = fichaMecanica;
    }
    
    /*
    ---GETTERS
    */

    public int getNro() {
        return nro;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getMecanico() {
        return mecanico;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public String getTitular() {
        return titular;
    }

    public String getCompaniaSeguro() {
        return companiaSeguro;
    }

    public String getEstado() {
        return estado;
    }

    public String getFichaMecanica() {
        return fichaMecanica;
    }
    
}
    