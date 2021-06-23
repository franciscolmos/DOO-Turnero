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
     * Test of consultarTurno method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testConsultarTurno() {
//        System.out.println("consultarTurno");
//        String nro = "";
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        TurnoDTO expResult = null;
//        TurnoDTO result = instance.consultarTurno(nro);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarTurnos method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testListarTurnos() {
//        System.out.println("listarTurnos");
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        List<TurnoDTO> expResult = null;
//        List<TurnoDTO> result = instance.listarTurnos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

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
        String nro = "10";
        String dia = "98";
        String hora = "98";
        String mecanico = "Mecanico98";
        TurnoDAOImplSql instance = new TurnoDAOImplSql();
        boolean expResult = true;
        boolean result = instance.modificarTurno(nro, dia, hora, mecanico);
        assertEquals(expResult, result);
    }

    /**
     * Test of cerrarConexion method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testCerrarConexion() {
//        System.out.println("cerrarConexion");
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        instance.cerrarConexion();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarTurnosPorCriterio method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testListarTurnosPorCriterio() {
//        System.out.println("listarTurnosPorCriterio");
//        String Estado = "";
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        List<TurnoDTO> expResult = null;
//        List<TurnoDTO> result = instance.listarTurnosPorCriterio(Estado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of confirmarTurno method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testConfirmarTurno() {
//        System.out.println("confirmarTurno");
//        String nro = "";
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        boolean expResult = false;
//        boolean result = instance.confirmarTurno(nro);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of cancelarTurno method, of class TurnoDAOImplSql.
     */
//    @Test
//    public void testCancelarTurno() {
//        System.out.println("cancelarTurno");
//        String nro = "";
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        boolean expResult = false;
//        boolean result = instance.cancelarTurno(nro);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registrarFichaMecanica method, of class TurnoDAOImplSql.
//     */
//    @Test
//    public void testRegistrarFichaMecanica() {
//        System.out.println("registrarFichaMecanica");
//        String nro = "";
//        String fichaMecanica = "";
//        TurnoDAOImplSql instance = new TurnoDAOImplSql();
//        boolean expResult = false;
//        boolean result = instance.registrarFichaMecanica(nro, fichaMecanica);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
