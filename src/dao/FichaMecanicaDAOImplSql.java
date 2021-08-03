/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author felipe
 */
public class FichaMecanicaDAOImplSql implements FichaMecanicaDAO {
    
    private ConexionSql conexion = null;

    public FichaMecanicaDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public boolean insertarFicha(int legajoMecanico) {
        Connection con = null;
        PreparedStatement sentencia = null;
        
        try {
            con = conexion.getConnection();
            String sql = "insert into 'fichas mecanicas' (nro_ficha, legajo_mecanico, estado, observaciones)" +
                         " values ((select max(nro_ficha) +1" +
                         "              from 'fichas mecanicas'), " +
                         "          ?, " +
                         "          'Pendiente', " +
                         "          '')";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, legajoMecanico);
            
            int rs = sentencia.executeUpdate();
            return (rs > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
    
}
