/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Modelo;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import vista.InterfazTurno;

/**
 *
 * @author francisco
 */

public abstract class Controlador extends MouseAdapter implements ActionListener {
    InterfazTurno VISTA = null;
    Modelo MODELO = null;
}
