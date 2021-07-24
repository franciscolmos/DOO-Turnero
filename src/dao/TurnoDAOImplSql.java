/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MecanicoDTO;
import dto.TurnoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
    public TurnoDTO consultarTurno(int nroTurno) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        TurnoDTO turno = null;

        try {
            con = conexion.getConnection();
            String sql = "select * from turnos where nro_turno = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroTurno);

            rs = sentencia.executeQuery();
            
            String anoMes;
            int legajoMecanico;
            int nroPoliza;
            String dia;
            String hora;
            int nroTitular;
            String cuitCompania;
            String estado;
            
            while (rs.next()) {
                anoMes = rs.getString("ano_mes");
                legajoMecanico = rs.getInt("legajo_mecanico");
                nroPoliza = rs.getInt("nro_poliza");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                nroTitular = rs.getInt("nro_titular");
                cuitCompania = rs.getString("cuit_compania");
                estado = rs.getString("estado");
                turno = new TurnoDTO(nroTurno, anoMes, legajoMecanico, 
                                     nroPoliza, dia, hora, nroTitular, 
                                     cuitCompania, estado);
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
            String sql = "select * from turnos";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            int nroTurno;
            String anoMes;
            int legajoMecanico;
            int nroPoliza;
            String dia;
            String hora;
            int nroTitular;
            String cuitCompania;
            String estado;
            TurnoDTO turno;

            while (rs.next()) {
                nroTurno = rs.getInt("nro_turno");
                anoMes = rs.getString("ano_mes");
                legajoMecanico = rs.getInt("legajo_mecanico");
                nroPoliza = rs.getInt("nro_poliza");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                nroTitular = rs.getInt("nro_titular");
                cuitCompania = rs.getString("cuit_compania");
                estado = rs.getString("estado");
                turno = new TurnoDTO(nroTurno, anoMes, legajoMecanico, 
                                     nroPoliza, dia, hora, nroTitular, 
                                     cuitCompania, estado);
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
    public boolean insertarTurno(List<MecanicoDTO> listadoMecanicos) {
        Connection con = null;
        PreparedStatement sentencia = null;
    
        if(this.listarTurnos().size() > 0){
            return false;
        }else{
            for (int i = 0; i < listadoMecanicos.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    try {
                        con = conexion.getConnection();

                        String sql =  "insert into turnos (nro_turno, ano_mes, legajo_mecanico, "
                                    + "nro_poliza, dia, hora, nro_titular, cuit_compania, estado) "
                                    + "values(?,?,?,?,?,?,?,?,?)";
                        sentencia = con.prepareStatement(sql);
                        sentencia.setInt(1, (j+1));
                        sentencia.setString(2, "2021-07");
                        sentencia.setInt(3, listadoMecanicos.get(i).getLegajo());
                        sentencia.setInt(4, -1);
                        sentencia.setInt(5, (j+1));
                        sentencia.setString(6, (j+7)+":00 AM");
                        sentencia.setInt(7, -1);
                        sentencia.setString(8, "");
                        sentencia.setString(9, "No Asignado");


                        int resultado = sentencia.executeUpdate();
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
            }
            return true;
        }
    }

    @Override
    public boolean asignarTurno(int nroPoliza, int nroTitular, String cuitCompania, 
                                  String anoMes, int legajoMecanico, String dia, String hora) {
        Connection con = null;
        PreparedStatement sentencia = null;
        try {
            con = conexion.getConnection();
            String sql = "update turnos set nro_poliza=?,nro_titular=?,"
                       + "cuit_compania=?, estado='Asignado' where ano_mes=? "
                       + "and legajo_mecanico=? and dia=? and hora=?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nroPoliza);
            sentencia.setInt(2, nroTitular);
            sentencia.setString(3, cuitCompania);
            sentencia.setString(4, anoMes);
            sentencia.setInt(5, legajoMecanico);
            sentencia.setString(6, dia);
            sentencia.setString(7, hora);

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
            String sql = "select * from turnos where estado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, Estado);

            rs = sentencia.executeQuery();

            int nroTurno;
            String anoMes;
            int legajoMecanico;
            int nroPoliza;
            String dia;
            String hora;
            int nroTitular;
            String cuitCompania;
            TurnoDTO turno;

            while (rs.next()) {
                nroTurno = rs.getInt("nro_turno");
                anoMes = rs.getString("ano_mes");
                legajoMecanico = rs.getInt("legajo_mecanico");
                nroPoliza = rs.getInt("nro_poliza");
                dia = rs.getString("dia");
                hora = rs.getString("hora");
                nroTitular = rs.getInt("nro_titular");
                cuitCompania = rs.getString("cuit_compania");
                turno = new TurnoDTO(nroTurno, anoMes, legajoMecanico, nroPoliza,
                                     dia, hora, nroTitular, cuitCompania, Estado);
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
}
