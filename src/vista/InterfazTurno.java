/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ItemListener;

/**
 *
 * @author francisco
 */
public interface InterfazTurno {
    
    public static enum Operacion {
        CONSULTAR, TURNO, NUEVO_TURNO, VOLVER_HOME, TITULAR, VOLVER_NUEVO_TURNO, NUEVO_TITULAR;
    };
    
    void setControlador(Controlador c, ItemListener ci);

    void iniciaVista();
    
    void cerrarVista();
    
    void limpiaVista();
}
