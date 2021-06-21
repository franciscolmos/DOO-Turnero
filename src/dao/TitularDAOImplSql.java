/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author felipe
 */
public class TitularDAOImplSql implements TitularDAO {
    private ConexionSql conexion = null;

    public TitularDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }
}
