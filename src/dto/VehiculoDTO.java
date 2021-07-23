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
public class VehiculoDTO {
    private String nroTitular;
    private int nroPoliza;
    private String modelo;
    private String marca;
    private String cuitCompania;

    public VehiculoDTO(int nroPoliza, String modelo, String marca, String nroTitular, String cuitCompania) {
        this.nroPoliza = nroPoliza;
        this.modelo = modelo;
        this.marca = marca;
        this.nroTitular = nroTitular;
        this.cuitCompania = cuitCompania;
    }
  
    public String getNroTitular() {
        return nroTitular;
    }

    public int getNroPoliza() {
        return nroPoliza;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getCuitCompania() {
        return cuitCompania;
    }

    public void setNroTitular(String nroTitular) {
        this.nroTitular = nroTitular;
    }

    public void setNroPoliza(int nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCuitCompania(String cuitCompania) {
        this.cuitCompania = cuitCompania;
    }
}
