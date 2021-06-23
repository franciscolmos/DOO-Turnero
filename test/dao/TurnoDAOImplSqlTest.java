/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TurnoDTO;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class TurnoDAOImplSqlTest {
    
    public TurnoDAOImplSqlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarTurno method, of class TurnoDAOImplSql.
     */
    @Test
    public void testInsertarTurno() {
        System.out.println("insertarTurno");
        String dia = "99";
        String hora = "99";
        String mecanico = "Mecanico99";
        String vehiculo = "Vehiculo99";
        String titular = "Titular99";
        String companiaSeguro = "Compania99";
        TurnoDAOImplSql instance = new TurnoDAOImplSql();
        boolean expResult = true;
        boolean result = instance.insertarTurno(dia, hora, mecanico, vehiculo, titular, companiaSeguro);
        assertEquals(expResult, result);
    }

    /**
     * Test of modificarTurno method, of class TurnoDAOImplSql.
     */
    @Test
    public void testModificarTurno() {
        System.out.println("modificarTurno");
        String nro = "6";
        String dia = "99";
        String hora = "99";
        String mecanico = "Mecanico99";
        TurnoDAOImplSql instance = new TurnoDAOImplSql();
        boolean expResult = true;
        boolean result = instance.modificarTurno(nro, dia, hora, mecanico);
        assertEquals(expResult, result);
    }
    
}
