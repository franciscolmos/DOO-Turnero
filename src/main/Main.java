/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.Controlador;
import controlador.EncRecepcionControlador;
import modelo.Modelo;
import modelo.Turno;
import vista.InterfazTurno;
import vista.vistaHome;
import javax.swing.SwingUtilities;

/**
 *
 * @author francisco
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // Necesario para levantar el main en un hilo que luego nos permitira utilizar el robot y la window para hacer los test funcionales
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //modelo:
                Modelo modelo = new Turno();

                //vista:
                InterfazTurno vista = new vistaHome();

                //controlador:
                Controlador control = new EncRecepcionControlador(vista, modelo);
            }
        });
    }
}
