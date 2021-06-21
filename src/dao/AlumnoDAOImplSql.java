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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dto.AlumnoDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author agustin
 */
public class AlumnoDAOImplSql implements AlumnoDAO {

    private ConexionSql conexion = null;

    public AlumnoDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public AlumnoDTO buscarAlumno(String nombreAlumno, String apellidoAlumno) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        AlumnoDTO alumno = null;

        try {
            con = conexion.getConnection();
            String sql = "select legajo, nombre, apellido, fechaNacimiento, sexo "
                    + "from alumnos where nombre = ? and apellido = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombreAlumno);
            sentencia.setString(2, apellidoAlumno);

            rs = sentencia.executeQuery();

            String nombre;
            String apellido;
            Date fechaNacimiento;
            String sexo;
            int legajo;

            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fechaNacimiento"));
                sexo = rs.getString("sexo");
                legajo = rs.getInt("legajo");
                alumno = new AlumnoDTO(apellido, nombre, fechaNacimiento, sexo, legajo);
            }

        } catch (SQLException | ParseException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return alumno;
    }

    @Override
    public List<AlumnoDTO> listarAlumnos() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<AlumnoDTO> listaAlumnos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select nombre, apellido, fechaNacimiento, sexo, legajo "
                    + "from alumnos order by apellido, nombre";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int id;
            String nombre;
            String apellido;
            Date fechaNacimiento;
            String sexo;
            int legajo;
            AlumnoDTO alumno;

            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                fechaNacimiento = rs.getString("fechaNacimiento") != null ? new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fechaNacimiento")) : null;
                sexo = rs.getString("sexo");
                legajo = rs.getInt("legajo");
                alumno = new AlumnoDTO(apellido, nombre, fechaNacimiento, sexo, legajo);
                listaAlumnos.add(alumno);
            }

        } catch (SQLException | ParseException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return listaAlumnos;
    }

    @Override
    public boolean insertarAlumno(String apellido, String nombre, Date fechaNacimiento, String sexo) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into alumnos (nombre, apellido, fechaNacimiento, sexo) "
                    + "values(?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(fechaNacimiento));
            sentencia.setString(4, sexo);

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
    public boolean modificarAlumno(int legajo, String apellido, String nombre, Date fechaNacimiento, String sexo) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "update alumnos set nombre=?,apellido=?,fechaNacimiento=?,sexo=? where legajo=?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(fechaNacimiento));
            sentencia.setString(4, sexo);
            sentencia.setInt(5, legajo);

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
    public boolean borrarAlumno(int legajo) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();;
            String sql = "delete from alumnos where legajo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, legajo);

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
    public AlumnoDTO buscarAlumno(int legajo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlumnoDTO> listarAlumnosPorCriterio(String nombre, String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

}
