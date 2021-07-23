/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.FabricaDAO;
import dao.TitularDAO;
import dto.TitularDTO;
import java.util.List;

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
    
    public List<TitularDTO> listarTitulares() {
        List<TitularDTO> listaTitulares = titularDao.listarTitulares();
        return listaTitulares;
    }
    
    public boolean insertarTitular(int nroTitular, String tipoDNI, String nroDNI, String nombre, String apellido, String telefono){
        boolean titular = titularDao.insertarTitular(nroTitular, tipoDNI, nroDNI, nombre, apellido, telefono);
        return titular;
    };
    
     public TitularDTO buscarTitular(String apellidoTitular, String nombreTitular) {
        TitularDTO titular = titularDao.buscarTitular(apellidoTitular, nombreTitular);
        return titular;
     }
    
    @Override
    protected void finalize() throws Throwable {
        titularDao.cerrarConexion();
    }
}
