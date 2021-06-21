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
public class CompaniaDTO {
    
    String razonSocial;
    String cuit;
    String direccion;
    String telefono;
    
    public CompaniaDTO(String razonSocial, String cuit, String direccion, String telefono) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
