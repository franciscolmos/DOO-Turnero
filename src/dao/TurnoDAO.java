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
    
    List<TurnoDTO> listarTurnos();
    
    List<TurnoDTO> listarTurnosPorCriterio(String Estado);
    
    boolean insertarTurno(List<MecanicoDTO> listadoMecanicos);
    
    boolean asignarTurno(int nroPoliza, int nroTitular, String cuitCompania, 
                         String anoMes, int legajoMecanico, String dia, String hora);
    
    boolean confirmarTurno(String nro);
     
    boolean cancelarTurno(String nro);
    
    //boolean registrarFichaMecanica(String nro, String fichaMecanica);
    
    void cerrarConexion();
}
