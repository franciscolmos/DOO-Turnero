/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MecanicoDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francisco
 */
public class MecanicoDAOImplSqlTest {
    
    public MecanicoDAOImplSqlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarMecanico method, of class MecanicoDAOImplSql.
     */
    @Test
    public void testConsultarMecanico() {
        MecanicoDTO expResult = new MecanicoDTO("Gonzalez", "Hector", "DNI", "27483726", "734927492", 1, "Externo", "Frenos");
        System.out.println("consultarMecanico: Legajo: " + expResult.getLegajo());
        MecanicoDAOImplSql instance = new MecanicoDAOImplSql();
        MecanicoDTO result = instance.consultarMecanico(Integer.toString(expResult.getLegajo()));
        assertEquals(expResult.getApellido(), result.getApellido());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getTipoDNI(), result.getTipoDNI());
        assertEquals(expResult.getNroDNI(), result.getNroDNI());
        assertEquals(expResult.getTelefono(), result.getTelefono());
        assertEquals(expResult.getArea(), result.getArea());
        assertEquals(expResult.getCodEspecialidad(), result.getCodEspecialidad());
    }
}
