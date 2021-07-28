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
     * Test of consultarTurnoPorMecanicoDiaYHora method, of class TurnoDAOImplSql.
     */
    @Test
    public void testconsultarTurnoPorMecanicoDiaYHora() {
        System.out.println("Consultar Turno Legajo Mecanico 10, dia 5 11:00 AM");
        int legajoMecanico = 10;
        String dia = "5";
        String hora = "11:00 AM";
        TurnoDAOImplSql instance = new TurnoDAOImplSql();
        TurnoDTO turnoExpResult = new TurnoDTO(5, "2021-07", 10, -1, dia, hora, -1, "", "No Asignado");
        TurnoDTO turnoObtenido = instance.consultarTurnoPorMecanicoDiaYHora(legajoMecanico, dia, hora);
        assertEquals(turnoExpResult.getNroTurno(), turnoObtenido.getNroTurno());
        assertEquals(turnoExpResult.getCuitCompania(), turnoObtenido.getCuitCompania());
        assertEquals(turnoExpResult.getNroPoliza(), turnoObtenido.getNroPoliza());
        assertEquals(turnoExpResult.getEstado(), turnoObtenido.getEstado());
    } 
}
