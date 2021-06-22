/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TitularDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author felipe
 */
public class TitularDAOImplSql implements TitularDAO {
    private ConexionSql conexion = null;

    public TitularDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public TitularDTO buscarTitular(String apellidoTitular, String nombreTitular) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TitularDTO titular = null;

        try {
            con = conexion.getConnection();
            String sql = "select nombre, apellido, tipoDNI, nroDNI, telefono, compania "
                    + "from titular where nombre = ? and apellido = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombreTitular);
            sentencia.setString(2, apellidoTitular);

            rs = sentencia.executeQuery();

            String nombre;
            String apellido;
            String tipoDNI;
            String nroDNI;
            String telefono;
            String compania;
            
            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                tipoDNI = rs.getString("tipoDNI");
                nroDNI = rs.getString("nroDNI");
                telefono = rs.getString("telefono");
                compania = rs.getString("compania");
                
                titular = new TitularDTO(apellido, nombre, tipoDNI, nroDNI, telefono, compania);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return titular;
    }

    @Override
    public boolean insertarTitular(String nombre, String apellido, String tipoDNI, String nroDNI, String telefono, String compania) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into alumnos (nombre, apellido, tipoDNI, nroDNI, telefono, compania) "
                    + "values(?,?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, tipoDNI);
            sentencia.setString(4, nroDNI);
            sentencia.setString(5, telefono);
            sentencia.setString(6, compania);

            int resultado = sentencia.executeUpdate();

            return (resultado > 0);
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

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
}
