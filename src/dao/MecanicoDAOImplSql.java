/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MecanicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class MecanicoDAOImplSql implements MecanicoDAO {
    private ConexionSql conexion = null;

    public MecanicoDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public List<MecanicoDTO> listarMecanicosConCriterios(String especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<MecanicoDTO> listaMecanicos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * from mecanicos where especialidad = ?";
            //String sql = "select * from mecanicos";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, especialidad);

            rs = sentencia.executeQuery();

            String apellido;
            String nombre;
            String tipoDNI;
            String nroDNI;
            String telefono;
            int legajo;
            String area;
            String especialidadMecanico;
            MecanicoDTO mecanico;

            while (rs.next()) {
                apellido = rs.getString("apellido");
                nombre = rs.getString("nombre");
                tipoDNI = rs.getString("tipoDNI");
                nroDNI = rs.getString("nroDNI");
                telefono = rs.getString("telefono");
                legajo = rs.getInt("legajo");
                area = rs.getString("area");
                especialidadMecanico = rs.getString("especialidad");
                mecanico = new MecanicoDTO(apellido, nombre, tipoDNI, nroDNI, telefono,
                                           legajo, area, especialidadMecanico);
                listaMecanicos.add(mecanico);
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
        return listaMecanicos;
    }

    @Override
    public boolean insertarMecanico(String apellido, String nombre, String tipoDNI, 
                                    String nroDNI, String telefono, String legajo, 
                                    String area,String especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into mecanicos (apellido, nombre, tipoDNI, nroDNI, "
                    + "telefono, legajo, area, especialidad) values(?,?,?,?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, apellido);
            sentencia.setString(2, nombre);
            sentencia.setString(3, tipoDNI);
            sentencia.setString(4, nroDNI);
            sentencia.setString(5, telefono);
            sentencia.setString(6, legajo);
            sentencia.setString(7, area);
            sentencia.setString(8, especialidad);
            
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
