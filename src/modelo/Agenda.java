/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.AgendaDAO;
import dao.FabricaDAO;
import dto.AgendaDTO;
import dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Agenda extends Modelo {
    private final FabricaDAO fabricaDao;
    private final AgendaDAO agendaDao;
    
    public Agenda() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        agendaDao = fabricaDao.getAgendaDao();
    }
    
    public List<AgendaDTO> listarAgenda(String mecanicoNombre, 
                                        String estadoTurno) {
        List<AgendaDTO> listaAgendas = agendaDao.listarAgenda(mecanicoNombre, 
                                                              estadoTurno);
        return listaAgendas;
    }
    
    public List<AgendaDTO> listarAgendas() {
        List<AgendaDTO> listaAgendas = agendaDao.listarAgendas();
        return listaAgendas;
    }
    
    public List<AgendaDTO> listarAgendaPorFecha(String mecanicoNombre, 
                                        String estadoTurno, String anoMes, String dia) {
        List<AgendaDTO> listaAgendas = agendaDao.listarAgendaPorFecha(mecanicoNombre, 
                                                              estadoTurno, anoMes, dia);
        return listaAgendas;
    }
    
    public List<AgendaDTO> listarAgendaPorAnoMes(String anoMes){
        List<AgendaDTO> listarAgendas = agendaDao.listarAgendaPorAnoMes(anoMes);
        return listarAgendas;
    }
    
    public boolean insertarAgendas(List<MecanicoDTO> listadoMecanicos) {
        return agendaDao.insertarAgendas(listadoMecanicos);
    }
    
    @Override
    protected void finalize() throws Throwable {
        agendaDao.cerrarConexion();
    }
}
