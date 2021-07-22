/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TitularDTO;
import java.util.List;

/**
 *
 * @author felipe
 */
public interface TitularDAO {
    
    List<TitularDTO> listarTitulares();
    
    TitularDTO buscarTitular(String apellido, String nombre);
    
    boolean insertarTitular(String nombre, String apellido, String tipoDNI, String nroDNI, String telefono,String compania);

    void cerrarConexion();
}
