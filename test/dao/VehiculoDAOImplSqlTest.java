/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.VehiculoDTO;
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
        int nroPoliza = 1;
        VehiculoDAOImplSql instance = new VehiculoDAOImplSql();
        VehiculoDTO expResult = new VehiculoDTO(1, "Modelo1", "Marca1", "1", "1-111-1");
        System.out.println("consultarVehiculo Nro Polia:" + expResult.getNroPoliza() + " | "
                                           + "Marca: " + expResult.getMarca() + " | " 
                                           + "Modelo: " + expResult.getModelo() + " | "
                                           + "Nro Titular: " + expResult.getNroTitular() + " | "
                                           + "Cuit Compania: " + expResult.getCuitCompania());
        VehiculoDTO result = instance.consultarVehiculo(nroPoliza);
        assertEquals(expResult.getNroPoliza(), result.getNroPoliza());
        assertEquals(expResult.getMarca(), result.getMarca());
        assertEquals(expResult.getModelo(), result.getModelo());
        assertEquals(expResult.getNroTitular(), result.getNroTitular());
        assertEquals(expResult.getCuitCompania(), result.getCuitCompania());
    }  
}
