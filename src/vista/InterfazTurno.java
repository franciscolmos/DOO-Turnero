/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;

/**
 *
 * @author francisco
 */
public interface InterfazTurno {
    
    public static enum Operacion {
        CONSULTAR, TURNO, CLIENTE, EMPLEADO;
    };
    
    void setControlador(Controlador c);

    void iniciaVista();
}
