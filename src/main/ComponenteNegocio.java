/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import dao.MecanicoDAO;
import dao.FabricaDAO;
import dto.MecanicoDTO;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");

    private final MecanicoDAO mecanicoDAO = fabricaDao.getMecanicoDao();

    public void listarMecanicos() {
        List<MecanicoDTO> listadoMecanicos = mecanicoDAO.listarMecanicosConCriterios("Frenos");
        for (MecanicoDTO mecanico : listadoMecanicos) {
            System.out.println("Encontrado: apellido: " + mecanico.getApellido()
                             + " - nombre: " + mecanico.getNombre()
                             + " - tipoDNI: " + mecanico.getTipoDNI()
                             + " - nroDNI: " + mecanico.getNroDNI()
                             + " - telefono: " + mecanico.getTelefono()
                             + " - legajo: " + mecanico.getLegajo()
                             + " - area: " + mecanico.getArea()
                             + " - especialidad: " + mecanico.getEspecialidad());
        }
    }

    public boolean insertarMecanico(String apellido, String nombre, String tipoDNI, 
                             String nroDNI, String telefono, String legajo, String area,
                             String especialidad) {
        return mecanicoDAO.insertarMecanico(apellido, nombre, tipoDNI, nroDNI, telefono,
                                            legajo, area, especialidad);
    }

    @Override
    protected void finalize() throws Throwable {
        mecanicoDAO.cerrarConexion();
    }
}
