/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface VehiculoDAO {
    
    VehiculoDTO consultarVehiculo(int nroPoliza);
    
    boolean insertarVehiculo(int nroPoliza,
                             String modelo,
                             String marca,
                             String nroTitular,
                             String cuitCompania);
    
    List<VehiculoDTO> listarVehiculosPorTitular(String legajoTitular);
    
    void cerrarConexion();
}
