/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.FichaMecanicaDAO;

/**
 *
 * @author felipe
 */
public class FichaMecanica extends Modelo {
    private final FabricaDAO fabricaDao;
    private final FichaMecanicaDAO fichaMecanicaDao;
    
    public FichaMecanica() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        fichaMecanicaDao = fabricaDao.getFichaMecanicaDao();
    }
    
    public boolean insertarFicha( int legajoMecanico) {
        return fichaMecanicaDao.insertarFicha(legajoMecanico);
    }
    
    public boolean registrarFichaMecanica(String nroFicha, String obs){
        return fichaMecanicaDao.registrarFichaMecanica(nroFicha, obs);
    }
}
