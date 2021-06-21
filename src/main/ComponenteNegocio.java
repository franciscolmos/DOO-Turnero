/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.EspecialidadDAO;
import java.util.Date;
import java.util.List;
import dao.FabricaDAO;
import dto.EspecialidadDTO;

/**
 *
 * @author agustin
 */
public class ComponenteNegocio {

    private final FabricaDAO fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");

    private final EspecialidadDAO especialidadDAO = fabricaDao.getEspecialidadDAO();

    public void list() {
        List<EspecialidadDTO> listadoEspecialidades = especialidadDAO.listarEspecialidades();
        if (listadoEspecialidades != null) {
            for (EspecialidadDTO especialidad: listadoEspecialidades) {
                System.out.println(" Codigo Especialidad: " + especialidad.getCodigo() + 
                               " - Nombre: " + especialidad.getNombre() +
                               " - Descripcion: " + especialidad.getDescripcion());
            }
            
        } else {
            System.err.println("No encontrado");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        especialidadDAO.cerrarConexion();
    }
}
