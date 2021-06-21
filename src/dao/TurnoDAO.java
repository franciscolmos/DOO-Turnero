/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TurnoDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface TurnoDAO {
    TurnoDTO consultarTurno(String nro);
    
    List<TurnoDTO> listarTurnos();
    
    List<TurnoDTO> listarTurnosPorCriterio(String titular);
    
    boolean insertarTurno(String dia, String hora, String mecanico,
                          String vehiculo, String titular, 
                          String companiaSeguro);
    
    boolean modificarTurno(String nro, String dia, String hora, String mecanico);
    
    boolean confirmarTurno(String nro);
     
    boolean cancelarTurno(String nro);
    
    boolean registrarFichaMecanica(String nro, String fichaMecanica);
    
    void cerrarConexion();
}
