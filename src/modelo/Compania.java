/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.CompaniaDAO;
import dto.CompaniaDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Compania extends Modelo {
    private final FabricaDAO fabricaDao;
    private final CompaniaDAO companiaDao;
    
    public Compania() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        companiaDao = fabricaDao.getCompaniaDao();
    }
    
    public List<CompaniaDTO> listarCompanias() {
        List<CompaniaDTO> listaCompanias = companiaDao.listarCompanias();
        return listaCompanias;
    }
    
    public boolean insertarCompania(String razonSocial, String cuit, 
                                    String direccion, String telefono) {
        return companiaDao.insertarCompania(razonSocial, cuit, direccion, telefono);
    }
    
    @Override
    protected void finalize() throws Throwable {
        companiaDao.cerrarConexion();
    }
}
