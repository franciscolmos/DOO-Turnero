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
    
    boolean insertarTitular(int nroTitular, String tipoDNI, String nroDNI, String nombre, String apellido, String telefono);

    void cerrarConexion();
}
