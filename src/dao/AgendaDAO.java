/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AgendaDTO;
import java.util.List;

/**
 *
 * @author benja
 */
public interface AgendaDAO {
    
        List<AgendaDTO> listarAgenda(String mecanicoNombre, String estadoTurno);
        
        List<AgendaDTO> listarAgendaPorFecha(String mecanicoNombre, String estadoTurno, String fecha);
        
        boolean modificarAgenda(String dia, String horario, String mecanico);
        
        void cerrarConexion();

}
