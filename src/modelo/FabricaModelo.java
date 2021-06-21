/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author felipe
 */
public class FabricaModelo extends FabricaModeloMethod {

    @Override
    public Modelo crearModelo(String modelo) {
        if( modelo.contains("turno") ){
            return new modelo.Turno();
        }
        if( modelo.contains("mecanico")){
            return new modelo.Mecanico();
        }
        if( modelo.contains("titular") ){
            return new modelo.Titular();
        }
        if( modelo.contains("vehiculo") ){
            return new modelo.Vehiculo();
        }
        if( modelo.contains("compania") ){
            return new modelo.Compania();
        }
        return null;
    }
}
