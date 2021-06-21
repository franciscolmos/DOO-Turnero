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
    private String nroDNITitular;
    private int nroPoliza;
    private String modelo;
    private String marca;

    public VehiculoDTO(int nroPoliza, String modelo, String marca, String nroDNITitular) {
        this.nroPoliza = nroPoliza;
        this.modelo = modelo;
        this.marca = marca;
        this.nroDNITitular = nroDNITitular;
    }

    public String getNroDNITitular() {
        return nroDNITitular;
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

    public void setNroDNITitular(String nroDNITitular) {
        this.nroDNITitular = nroDNITitular;
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
    
}
