/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.CompaniaDAO;

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
}
