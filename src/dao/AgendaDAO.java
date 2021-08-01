/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AgendaDTO;
import dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author benja
 */
public interface AgendaDAO {
    
        List<AgendaDTO> listarAgenda(String legajoMecanico, String estadoTurno);
        
        List<AgendaDTO> listarAgendas();
        
        List<AgendaDTO> listarAgendaPorFecha(String mecanicoNombre, String estadoTurno, String anoMes, String dia);
        
        List<AgendaDTO> listarAgendaPorAnoMes(String anoMes);
        
        boolean insertarAgendas(List<MecanicoDTO> listadoMecanicos);
        
        void cerrarConexion();

}
