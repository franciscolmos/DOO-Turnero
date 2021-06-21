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
    
    public TurnoDTO consultarTurno(String nro) {
        TurnoDTO turno = turnoDao.consultarTurno(nro);
        return turno;
    }
    
    public List<TurnoDTO> listarTurno() {
        List<TurnoDTO> listadoTurnos = turnoDao.listarTurnos();
        return listadoTurnos;
    }
    
    public boolean insertarTurno(String dia, String hora, String mecanico,
                                 String vehiculo, String titular, 
                                 String companiaSeguro) {
        return turnoDao.insertarTurno(dia, hora, mecanico, vehiculo, titular, companiaSeguro);
    }
    
    public boolean modificarTurno(String nro, String dia, String hora, String mecanico) {
        return turnoDao.modificarTurno(nro, dia, hora, mecanico);
    }
    
    @Override
    protected void finalize() throws Throwable {
        turnoDao.cerrarConexion();
    }
}
