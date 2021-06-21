/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;
import java.util.List;
import dao.TurnoDAO;
import dao.FabricaDAO;
import dto.TurnoDTO;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");

    private final TurnoDAO turnoDAO = fabricaDao.getTurnoDao();

    public void consultarTurno(String nro) {
        TurnoDTO turno = turnoDAO.consultarTurno(nro);
        if (turno != null) {
            System.out.println("Encontrado: Nro: " + turno.getNro() + " - Dia: " 
                             + turno.getDia() + " - Hora: " + turno.getHora() +
                               " - Mecanico: " + turno.getMecanico() + " - Vehiculo: "
                             + turno.getVehiculo() + " - Titular: " + turno.getTitular()
                             + " - Compania: " + turno.getCompaniaSeguro() + 
                               " - Estado: " + turno.getEstado() + " - Ficha: "
                             + turno.getFichaMecanica());
        } else {
            System.err.println("No encontrado");
        }
    }

    public void listarTurnos() {
        List<TurnoDTO> listadoTurnos = turnoDAO.listarTurnos();
        for (TurnoDTO turno : listadoTurnos) {
            System.out.println("Encontrado: Nro: " + turno.getNro() + " - Dia: " 
                             + turno.getDia() + " - Hora: " + turno.getHora() +
                               " - Mecanico: " + turno.getMecanico() + " - Vehiculo: "
                             + turno.getVehiculo() + " - Titular: " + turno.getTitular()
                             + " - Compania: " + turno.getCompaniaSeguro() + 
                               " - Estado: " + turno.getEstado() + " - Ficha: "
                             + turno.getFichaMecanica());
        }
    }

    public boolean insertarTurno(String dia, String hora, String mecanico,
                                 String vehiculo, String titular, 
                                 String companiaSeguro) {
        return turnoDAO.insertarTurno(dia, hora, mecanico, vehiculo, titular, companiaSeguro);
    }

    public boolean modificarTurno(String nro, String dia, String hora, String mecanico) {
        return turnoDAO.modificarTurno(nro, dia, hora, mecanico);
    }

    @Override
    protected void finalize() throws Throwable {
        turnoDAO.cerrarConexion();
    }
}
