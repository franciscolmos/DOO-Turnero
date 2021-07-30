/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.TurnoDAO;
import dao.FabricaDAO;
import dto.MecanicoDTO;
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
    
    public TurnoDTO consultarTurnoPorMecanicoDiaYHora(int legajoMecanico, String dia, String hora) {
        TurnoDTO turno = turnoDao.consultarTurnoPorMecanicoDiaYHora(legajoMecanico, dia, hora);
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
    
    public boolean insertarTurno(List<MecanicoDTO> mecanicos) {
        return turnoDao.insertarTurno(mecanicos);
    }
    
    public boolean registrarFichaMecanica(String nro, String fichaMecanica) {
        return turnoDao.registrarFichaMecanica(nro, fichaMecanica);
    }
    
    public boolean asignarTurno(int nroPoliza, int nroTitular, String cuitCompania, 
                                String anoMes, int legajoMecanico, String dia, String hora) {
        return turnoDao.asignarTurno(nroPoliza, nroTitular, cuitCompania, anoMes, 
                                     legajoMecanico, dia, hora);
    }
    
    public String getObservaciones(String nro_ficha){
    return turnoDao.getObservaciones(nro_ficha);
    } 
    
    @Override
    protected void finalize() throws Throwable {
        turnoDao.cerrarConexion();
    }
}
