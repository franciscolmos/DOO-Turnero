/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;
import java.util.List;
import dao.VehiculoDAO;
import dao.FabricaDAO;
import dto.VehiculoDTO;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");

    private final VehiculoDAO vehiculoDAO = fabricaDao.getVehiculoDao();

    public void consultarVehiculo(int nroPoliza) {
        VehiculoDTO vehiculo = vehiculoDAO.consultarVehiculo(nroPoliza);
        if (vehiculo != null) {
            System.out.println("Encontrado: Nro Poliza: " + vehiculo.getNroPoliza() + 
                               " - Modelo: " + vehiculo.getModelo() +
                               " - Marca: " + vehiculo.getMarca() +
                               " - nroDNITitular: " + vehiculo.getNroDNITitular());
        } else {
            System.err.println("No encontrado");
        }
    }

    public boolean insertarVehiculo(int nroPoliza, String modelo, String marca, String nroDNITitular) {
        return vehiculoDAO.insertarVehiculo(nroPoliza, modelo, marca, nroDNITitular);
    }

    @Override
    protected void finalize() throws Throwable {
        vehiculoDAO.cerrarConexion();
    }
}
