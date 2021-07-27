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
            String sql = "select * from titulares";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int nroTitular;
            String nombre;
            String apellido;
            String tipoDNI;
            String nroDNI;
            String telefono;
            TitularDTO titular;

            while (rs.next()) {
                nroTitular = rs.getInt("nro_titular");
                tipoDNI = rs.getString("tipo_doc");
                nroDNI = rs.getString("nro_doc");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                telefono = rs.getString("telefono");
                titular = new TitularDTO(nroTitular, tipoDNI, nroDNI, nombre, apellido, telefono);
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
                         + "from titulares where nombre = ? and apellido = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombreTitular);
            sentencia.setString(2, apellidoTitular);

            rs = sentencia.executeQuery();

            int nroTitular;
            String tipoDNI;
            String nroDNI;
            String telefono;
            
            while (rs.next()) {
                nroTitular = rs.getInt("nro_titular");
                tipoDNI = rs.getString("tipo_doc");
                nroDNI = rs.getString("nro_doc");
                telefono = rs.getString("telefono");
                
                titular = new TitularDTO(nroTitular, tipoDNI, nroDNI, nombreTitular, apellidoTitular, telefono);
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
    public boolean insertarTitular(int nroTitular, String tipoDNI, String nroDNI, String nombre, String apellido, String telefono) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into titulares (nro_titular, tipo_doc, nro_doc, nombre, apellido, telefono) "
                         + "values(?,?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroTitular);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, tipoDNI);
            sentencia.setString(5, nroDNI);
            sentencia.setString(6, telefono);

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
