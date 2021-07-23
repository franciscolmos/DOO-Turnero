/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompaniaDTO;
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
public class CompaniaDAOImplSql implements CompaniaDAO {
    private ConexionSql conexion = null;

    public CompaniaDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public List<CompaniaDTO> listarCompanias() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<CompaniaDTO> listaTurnos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * from companias";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            String razonSocial;
            String cuit;
            String direccion;
            String telefono;
            CompaniaDTO compania;

            while (rs.next()) {
                cuit = rs.getString("cuit");
                razonSocial = rs.getString("razon_social");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                compania = new CompaniaDTO(razonSocial, cuit, direccion, telefono);
                listaTurnos.add(compania);
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
        return listaTurnos;
    }

    @Override
    public boolean insertarCompania(String razonSocial, String cuit, 
                                    String direccion, String telefono) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into companias (cuit, razon_social, direccion, "
                       + "telefono) values(?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, cuit);
            sentencia.setString(2, razonSocial);
            sentencia.setString(3, direccion);
            sentencia.setString(4, telefono);

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
