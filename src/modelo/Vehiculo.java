/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.VehiculoDAO;
import dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Vehiculo extends Modelo {
    
    private final FabricaDAO fabricaDao;
    private final VehiculoDAO vehiculoDao;
    
    public Vehiculo() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        vehiculoDao = fabricaDao.getVehiculoDao();
    }
    
    public boolean insertarVehiculo(int nroPoliza, String modelo, String marca, String nroTitular, String cuitCompania){
        boolean vehiculo = vehiculoDao.insertarVehiculo(nroPoliza, modelo, marca, nroTitular, cuitCompania);
         return vehiculo;
    };
    
    public List<VehiculoDTO> listarVehiculosPorTitular(String legajoTitular) {
        List<VehiculoDTO> listaVehiculos = vehiculoDao.listarVehiculosPorTitular(legajoTitular);
        return listaVehiculos;
    }
    
    public VehiculoDTO consultarVehiculo(int nroPoliza){
        return vehiculoDao.consultarVehiculo(nroPoliza);
    }
    
    @Override
    protected void finalize() throws Throwable {
        vehiculoDao.cerrarConexion();
    }
}
