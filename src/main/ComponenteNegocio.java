/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import dao.FabricaDAO;
import dao.AgendaDAO;
import dto.AgendaDTO;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    
    private final AgendaDAO agendaDAO = fabricaDao.getAgendaDao();

    public void listarAgenda(String mecanicoNombe, String estadoTurno){
    
        List<AgendaDTO> listadoAgenda = agendaDAO.listarAgenda(mecanicoNombe,estadoTurno);
        
        for (AgendaDTO agenda : listadoAgenda) {
            System.out.println("Encontrado: Dia: " 
                             + agenda.getDia() + " - Horario: " + agenda.getHorario() +
                               " - Mecanico: " + agenda.getMecanico() + " - Estado: "
                             + agenda.getEstado());
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        especialidadDAO.cerrarConexion();
    }
}
