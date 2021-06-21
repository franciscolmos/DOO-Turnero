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
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import dto.VehiculoDTO;

/**
 *
 * @author felipe
 */
public class VehiculoDAOImplSql implements VehiculoDAO {
    private ConexionSql conexion = null;

    public VehiculoDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public VehiculoDTO consultarVehiculo(int nroPoliza) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection();
            String sql = "select *"
                         + "from vehiculos where nroPoliza = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroPoliza);

            rs = sentencia.executeQuery();

            String modelo;
            String marca;
            String nroDNITitular;


            while (rs.next()) {
                nroPoliza = rs.getInt("nroPoliza");
                modelo = rs.getString("modelo");
                marca = rs.getString("marca");
                nroDNITitular = rs.getString("nroDNITitular");
                vehiculo = new VehiculoDTO(nroPoliza, modelo, marca, nroDNITitular);
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
        return vehiculo;
    }

    @Override
    public boolean insertarVehiculo(int nroPoliza, String modelo, String marca, String nroDNITitular) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into vehiculos (nroPoliza, modelo, marca, nroDNITitular)"
                       + "values(?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroPoliza);
            sentencia.setString(2, modelo);
            sentencia.setString(3, marca);
            sentencia.setString(4, nroDNITitular);

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
