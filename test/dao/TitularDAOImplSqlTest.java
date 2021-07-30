/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TitularDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francisco
 */
public class TitularDAOImplSqlTest {
    
    public TitularDAOImplSqlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarTitular method, of class TitularDAOImplSql.
     */
    @Test
    public void testBuscarTitular() {
        System.out.println("buscarTitular");
        TitularDTO expResult = new TitularDTO(3, "DNI", "33333333", "Titular3", "Apellido3", "351720549");
        TitularDAOImplSql instance = new TitularDAOImplSql();
        TitularDTO result = instance.buscarTitular(expResult.getApellido(), expResult.getNombre());
        assertEquals(expResult.getNroTitular(), result.getNroTitular());
        assertEquals(expResult.getTipoDNI(), result.getTipoDNI());
        assertEquals(expResult.getNroDNI(), result.getNroDNI());
        assertEquals(expResult.getTelefono(), result.getTelefono());
    }
    
}
