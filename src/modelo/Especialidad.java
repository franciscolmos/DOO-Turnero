/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dto.EspecialidadDTO;
import dao.EspecialidadDAO;
import dao.FabricaDAO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Especialidad {
    private final FabricaDAO fabricaDao;
    private final EspecialidadDAO especialidadDao;
    
    public Especialidad() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        especialidadDao = fabricaDao.getEspecialidadDAO();
    }
    
    public List<EspecialidadDTO> listarEspecialidades() {
        List<EspecialidadDTO> listaEspecialidades = especialidadDao.listarEspecialidades();
        return listaEspecialidades;
    }
    
    @Override
    protected void finalize() throws Throwable {
        especialidadDao.cerrarConexion();
    }
}
