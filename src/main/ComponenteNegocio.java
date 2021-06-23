/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.AgendaDAO;
import dao.FabricaDAO;
import modelo.Agenda;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    
    private Agenda agenda = new Agenda();

    public boolean usar() {
        return agenda.modificarAgenda("01", "09:00", "Hector");
    }
}