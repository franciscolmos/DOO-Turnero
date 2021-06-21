/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author agustin
 */
public class ConexionSql {
    private static final String URL = "jdbc:sqlite:/home/felipe/OneDrive/Facu/DOO/TP2Parcial/DOO-Turnero/src/db/DBEjemploDAO.db";
    private Connection connection = null;
    private static ConexionSql instancia = null;
    
    private ConexionSql() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                if (connection != null) {
                    System.out.println("Conexión OK");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public static ConexionSql getInstancia() {
        if(instancia == null) {
            instancia = new ConexionSql();
        }
        return instancia;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    protected void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        connection = null;
    }
    
}
