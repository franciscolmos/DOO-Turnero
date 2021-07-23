/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.TurnoDAO;
import dao.FabricaDAO;
import dto.TurnoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Turno extends Modelo {
    
    private final FabricaDAO fabricaDao;
    private final TurnoDAO turnoDao;
    
    public Turno() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        turnoDao = fabricaDao.getTurnoDao();
    }
    
    public TurnoDTO consultarTurno(int nroTurno) {
        TurnoDTO turno = turnoDao.consultarTurno(nroTurno);
        return turno;
    }
    
    public List<TurnoDTO> listarTurno() {
        List<TurnoDTO> listadoTurnos = turnoDao.listarTurnos();
        return listadoTurnos;
    }
    
    public List<TurnoDTO> listarTurnosPorCriterio(String Estado) {
        List<TurnoDTO> listadoTurnos = turnoDao.listarTurnosPorCriterio(Estado);
        return listadoTurnos;
    }
    
    public boolean insertarTurno(int nroTurno, String anoMes, int legajoMecanico, int nroPoliza, 
                                 String dia, String hora, int nroTitular, String cuitCompania,
                                 String estado) {
        return turnoDao.insertarTurno(nroTurno, anoMes, legajoMecanico, nroPoliza, 
                                      dia, hora, nroTitular, cuitCompania, estado);
    }
    
    public boolean asignarTurno(int nroPoliza, int nroTitular, String cuitCompania, 
                                String anoMes, int legajoMecanico, String dia, String hora) {
        return turnoDao.asignarTurno(nroPoliza, nroTitular, cuitCompania, anoMes, 
                                     legajoMecanico, dia, hora);
    }
    
    @Override
    protected void finalize() throws Throwable {
        turnoDao.cerrarConexion();
    }
}
