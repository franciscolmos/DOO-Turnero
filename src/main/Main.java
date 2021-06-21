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

/**
 *
 * @author francisco
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        ComponenteNegocio cliente = new ComponenteNegocio();

        cliente.consultarTurno("1");

        cliente.insertarTurno("2020-07-16", "12:00:00", "Panchito", "Camaro",
                               "Felipe", "Zurich");

        cliente.consultarTurno("6");
        
        cliente.listarTurnos();
        
        cliente.modificarTurno("6", "2002-02-20", "00:00:00", "Alberto");
        
        cliente.consultarTurno("6");
        
        cliente.listarTurnos();
        
        cliente = null;

        */
        
        //modelo:
        Modelo modelo = new Turno();
        //vista:
        InterfazTurno vista = new vistaHome();

        //controlador:
        Controlador control = new EncRecepcionControlador(vista, modelo);

        //configuramos la vista para que pueda enviar las acciones del usuario como eventos al controlador
        vista.setControlador(control);

        //y arrancamos la interfaz:
        vista.iniciaVista();
    }
}
