/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.TitularDAO;

/**
 *
 * @author felipe
 */
public class Titular extends Modelo {
    private final FabricaDAO fabricaDao;
    private final TitularDAO titularDao;
    
    public Titular() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        titularDao = fabricaDao.getTitularDao();
    }
}
