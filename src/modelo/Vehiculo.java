/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.VehiculoDAO;

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
}
