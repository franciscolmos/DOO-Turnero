/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.MecanicoDAO;
import dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public class Mecanico extends Modelo  {
    private final FabricaDAO fabricaDao;
    private final MecanicoDAO mecanicoDao;
    
    public Mecanico() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        mecanicoDao = fabricaDao.getMecanicoDao();
    }
    
    public List<MecanicoDTO> listarMecanicosConCriterios(String especialidad) {
        List<MecanicoDTO> listadoMecanicos = mecanicoDao.listarMecanicosConCriterios(especialidad);
        return listadoMecanicos;
    }
    
    public boolean insertarMecanico(String apellido, String nombre, String tipoDNI, 
                                    String nroDNI, String telefono, String legajo, String area,
                                    String especialidad) {
        return mecanicoDao.insertarMecanico(apellido, nombre, tipoDNI, nroDNI, 
                                            telefono, legajo, area, especialidad);
    }
    
    @Override
    protected void finalize() throws Throwable {
        mecanicoDao.cerrarConexion();
    }
}
