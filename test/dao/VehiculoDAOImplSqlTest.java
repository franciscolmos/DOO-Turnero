/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.VehiculoDTO;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class VehiculoDAOImplSqlTest {
    
    public VehiculoDAOImplSqlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarVehiculo method, of class VehiculoDAOImplSql.
     */
    @Test
    public void testConsultarVehiculo() {
        System.out.println("consultarVehiculo");
        int nroPoliza = 1;
        VehiculoDAOImplSql instance = new VehiculoDAOImplSql();
        VehiculoDTO expResult = new VehiculoDTO(1, "Modelo1", "Marca1", "11111111");
        VehiculoDTO result = instance.consultarVehiculo(nroPoliza);
        assertEquals(expResult.getNroPoliza(), result.getNroPoliza());
        assertEquals(expResult.getMarca(), result.getMarca());
        assertEquals(expResult.getModelo(), result.getModelo());
        assertEquals(expResult.getNroDNITitular(), result.getNroDNITitular());
    }

    /**
     * Test of insertarVehiculo method, of class VehiculoDAOImplSql.
     */
    @Test
    public void testInsertarVehiculo() {
        System.out.println("insertarVehiculo");
        int nroPoliza = 98;
        String modelo = "Modelo99";
        String marca = "Marca99";
        String nroDNITitular = "99999999";
        VehiculoDAOImplSql instance = new VehiculoDAOImplSql();
        boolean expResult = true;
        boolean result = instance.insertarVehiculo(nroPoliza, modelo, marca, nroDNITitular);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of cerrarConexion method, of class VehiculoDAOImplSql.
//     */
//    @Test
//    public void testCerrarConexion() {
//        System.out.println("cerrarConexion");
//        VehiculoDAOImplSql instance = new VehiculoDAOImplSql();
//        instance.cerrarConexion();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
