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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<TitularDTO> listarTitulares() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<TitularDTO> listaTitulares = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select *"
                         + "from titular";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            String nombre;
            String apellido;
            String tipoDNI;
            String nroDNI;
            String telefono;
            String compania;
            TitularDTO titular;

            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                tipoDNI = rs.getString("tipoDNI");
                nroDNI = rs.getString("nroDNI");
                telefono = rs.getString("telefono");
                compania = rs.getString("compania");
                titular = new TitularDTO(nombre, apellido, tipoDNI, nroDNI, telefono, compania);
                listaTitulares.add(titular);
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
        return listaTitulares;
    }

    @Override
    public TitularDTO buscarTitular(String apellidoTitular, String nombreTitular) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TitularDTO titular = null;

        try {
            con = conexion.getConnection();
            String sql = "select *"
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
            String sql = "insert into titular (nombre, apellido, tipoDNI, nroDNI, telefono, compania) "
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
