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
                         + "from vehiculos where nro_poliza = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroPoliza);

            rs = sentencia.executeQuery();

            String modelo;
            String marca;
            String nroTitular;
            String cuitCompania;

            while (rs.next()) {
                nroPoliza = rs.getInt("nro_poliza");
                modelo = rs.getString("modelo");
                marca = rs.getString("marca");
                nroTitular = rs.getString("nro_titular");
                cuitCompania = rs.getString("cuit_compania");
                vehiculo = new VehiculoDTO(nroPoliza, modelo, marca, nroTitular, cuitCompania);
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
    public boolean insertarVehiculo(int nroPoliza, String modelo, String marca, String nroTitular, String cuitCompania) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into vehiculos (nro_poliza, modelo, marca, nro_titular, cuit_compania)"
                       + "values(?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroPoliza);
            sentencia.setString(2, modelo);
            sentencia.setString(3, marca);
            sentencia.setString(4, nroTitular);
            sentencia.setString(5, cuitCompania);

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

    @Override
    public List<VehiculoDTO> listarVehiculosPorTitular(String legajoTitular) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<VehiculoDTO> listaVehiculos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select *"
                         + "from vehiculos where nro_titular = ?";
            //String sql = "select * from mecanicos";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, legajoTitular);

            rs = sentencia.executeQuery();

            int nroPoliza;
            String modelo;
            String marca;
            String cuitCompania;
            VehiculoDTO vehiculo;

            while (rs.next()) {
                nroPoliza = rs.getInt("nro_poliza");
                modelo = rs.getString("modelo");
                marca = rs.getString("marca");
                cuitCompania = rs.getString("cuit_compania");
                vehiculo = new VehiculoDTO(nroPoliza, modelo, marca, legajoTitular, cuitCompania);
                listaVehiculos.add(vehiculo);
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
        return listaVehiculos;
    }
}
