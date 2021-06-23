/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TurnoDTO;
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
public class TurnoDAOImplSql implements TurnoDAO {
    
    private ConexionSql conexion = null;

    public TurnoDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public TurnoDTO consultarTurno(String nro) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TurnoDTO turno = null;

        try {
            con = conexion.getConnection();
            String sql = "select nro, dia, hora, mecanico, vehiculo, titular, "
                         + "companiaSeguro, estado, fichaMecanica "
                         + "from turnos where nro = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nro);

            rs = sentencia.executeQuery();

            int nroTurno;
            String dia;
            String hora;
            String mecanico;
            String vehiculo;
            String titular;
            String companiaSeguro;
            String estado;
            String fichaMecanica;

            while (rs.next()) {
                nroTurno = rs.getInt("nro");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                mecanico = rs.getString("mecanico");
                vehiculo = rs.getString("vehiculo");
                titular = rs.getString("titular");
                companiaSeguro = rs.getString("companiaSeguro");
                estado = rs.getString("estado");
                fichaMecanica = rs.getString("fichaMecanica");
                turno = new TurnoDTO(nroTurno, dia, hora, mecanico, vehiculo,
                                     titular, companiaSeguro, estado, fichaMecanica);
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
        return turno;
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<TurnoDTO> listaTurnos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select nro, dia, hora, mecanico, vehiculo, titular, "
                         + "companiaSeguro, estado, fichaMecanica "
                         + "from turnos order by nro";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int nroTurno;
            String dia;
            String hora;
            String mecanico;
            String vehiculo;
            String titular;
            String companiaSeguro;
            String estado;
            String fichaMecanica;
            TurnoDTO turno;

            while (rs.next()) {
                nroTurno = rs.getInt("nro");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                mecanico = rs.getString("mecanico");
                vehiculo = rs.getString("vehiculo");
                titular = rs.getString("titular");
                companiaSeguro = rs.getString("companiaSeguro");
                estado = rs.getString("estado");
                fichaMecanica = rs.getString("fichaMecanica");
                turno = new TurnoDTO(nroTurno, dia, hora, mecanico, vehiculo,
                                     titular, companiaSeguro, estado, fichaMecanica);
                listaTurnos.add(turno);
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
    public boolean insertarTurno(String dia, String hora, 
                                 String mecanico, String vehiculo, 
                                 String titular, String companiaSeguro) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "insert into turnos (dia, hora, mecanico, vehiculo, "
                       + "titular, companiaSeguro, estado, fichaMecanica) "
                       + "values(?,?,?,?,?,?,?,?)";
            sentencia = con.prepareStatement(sql);
            //sentencia.setString(1, nro);
            sentencia.setString(1, dia);
            sentencia.setString(2, hora);
            sentencia.setString(3, mecanico);
            sentencia.setString(4, vehiculo);
            sentencia.setString(5, titular);
            sentencia.setString(6, companiaSeguro);
            sentencia.setString(7, "Asignado");
            sentencia.setString(8, "No creada");

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
    public boolean modificarTurno(String nro, String dia, String hora, 
                                  String mecanico) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "update turnos set dia=?,hora=?,mecanico=? where nro=?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, dia);
            sentencia.setString(2, hora);
            sentencia.setString(3, mecanico);
            sentencia.setString(4, nro);

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
    public List<TurnoDTO> listarTurnosPorCriterio(String Estado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<TurnoDTO> listaTurnos = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select nro, dia, hora, mecanico, vehiculo, titular, "
                         + "companiaSeguro, estado, fichaMecanica "
                         + "from turnos where estado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, Estado);

            rs = sentencia.executeQuery();

            int nroTurno;
            String dia;
            String hora;
            String mecanico;
            String vehiculo;
            String titular;
            String companiaSeguro;
            String estado;
            String fichaMecanica;
            TurnoDTO turno;

            while (rs.next()) {
                nroTurno = rs.getInt("nro");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                mecanico = rs.getString("mecanico");
                vehiculo = rs.getString("vehiculo");
                titular = rs.getString("titular");
                companiaSeguro = rs.getString("companiaSeguro");
                estado = rs.getString("estado");
                fichaMecanica = rs.getString("fichaMecanica");
                turno = new TurnoDTO(nroTurno, dia, hora, mecanico, vehiculo,
                                     titular, companiaSeguro, estado, fichaMecanica);
                listaTurnos.add(turno);
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
    public boolean confirmarTurno(String nro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cancelarTurno(String nro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarFichaMecanica(String nro, String fichaMecanica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
