/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface MecanicoDAO {
    List<MecanicoDTO> listarMecanicosConCriterios(String especialidad);
    List<MecanicoDTO> listarMecanicos();
    
    boolean insertarMecanico(String apellido, String nombre, String tipoDNI, 
                             String nroDNI, String telefono, String legajo, String area,
                             String especialidad);
    
    public MecanicoDTO consultarMecanico(String legajoMecanico);
    
    void cerrarConexion();
}
