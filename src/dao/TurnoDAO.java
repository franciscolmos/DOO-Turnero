/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MecanicoDTO;
import dto.TurnoDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface TurnoDAO {
    
    TurnoDTO consultarTurno(int nroTurno);
    
    public TurnoDTO consultarTurnoPorMecanicoAnoMesDiaYHora(int legajoMecanico, String anoMes, String dia, String hora);
    
    public List<TurnoDTO> listarTurnosPorAnoMes(String anoMes);
    
    List<TurnoDTO> listarTurnos();
    
    List<TurnoDTO> listarTurnosPorCriterio(String Estado);
    
    boolean insertarTurno(List<MecanicoDTO> listadoMecanicos);
    
    boolean asignarTurno(int nroPoliza, int nroTitular, String cuitCompania, 
                         String anoMes, int legajoMecanico, String dia, String hora);
    
    boolean confirmarTurno(int nro, String anoMes, int mecanico);
     
    boolean cancelarTurno(int nro, String anoMes, int mecanico);
    
    boolean registrarFichaMecanica(String observaciones, String fichaMecanica);
    
    String getObservaciones(String nro_ficha);
    
    void cerrarConexion();
}
