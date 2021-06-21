/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.MecanicoDAO;

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
}
