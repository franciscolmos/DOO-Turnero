/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AgendaDTO;
import dto.MecanicoDTO;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author benja
 */
public class AgendaDAOImplSql implements AgendaDAO{
    
    private ConexionSql conexion = null;
    
    public AgendaDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public List<AgendaDTO> listarAgenda(String legajoMecanico, String estadoTurno) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select distinct dia, agendas.ano_mes "
                        + "from agendas "
                        +   "join turnos "
                        +       "on agendas.ano_mes = turnos.ano_mes "
                        +          " and agendas.legajo_mecanico = turnos.legajo_mecanico "
                        + "where estado = ? and turnos.legajo_mecanico = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, legajoMecanico);
            
            rs = sentencia.executeQuery();

            String ano_mes;
            String dia;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                dia = rs.getString("dia");
                agenda = new AgendaDTO(ano_mes, parseInt(legajoMecanico), dia, "", estadoTurno);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }
    
    @Override
    public List<AgendaDTO> listarAgendas() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();           
            String sql = "select * from agendas";
            sentencia = con.createStatement();
            rs = sentencia.executeQuery(sql);
            
            String ano_mes;
            int legajo_mecanico;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                legajo_mecanico = rs.getInt("legajo_mecanico");
                agenda = new AgendaDTO(ano_mes, legajo_mecanico);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }
    
    @Override
    public boolean insertarAgendas(List<MecanicoDTO> listadoMecanicos) {
        Connection con = null;
        PreparedStatement sentencia = null;
        
        Date fechaActual = new Date();
        LocalDate localDate = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String month = Integer.toString(localDate.getMonthValue());
        String year = Integer.toString(localDate.getYear());
        String anoMes = year + "-" + month;
        if(this.listarAgendaPorAnoMes(anoMes).size() > 0){
            return false;
        }else{
            for (int i = 0; i < listadoMecanicos.size(); i++) {
                try {
                    con = conexion.getConnection();

                    String sql =  "insert into agendas (ano_mes, legajo_mecanico)"
                                + "values(?,?)";
                    sentencia = con.prepareStatement(sql);
                    sentencia.setString(1, anoMes);
                    sentencia.setInt(2, listadoMecanicos.get(i).getLegajo());

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
            return true;
        }
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public List<AgendaDTO> listarAgendaPorFecha(String legajoMecanico, String estadoTurno, String anoMes, String dia) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * "
                        + "from agendas "
                        +   "join turnos "
                        +       "on agendas.ano_mes = turnos.ano_mes "
                        +          " and  agendas.legajo_mecanico = turnos.legajo_mecanico "
                        + "where estado = ? and turnos.legajo_mecanico = ? "
                        +   "and turnos.ano_mes = ? "
                        +   "and dia = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, legajoMecanico);
            sentencia.setString(3, anoMes);
            sentencia.setString(4, dia);
            
            
            rs = sentencia.executeQuery();

            String ano_mes;
            int legajo_mecanico;
            String hora;
            String estado;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                legajo_mecanico = rs.getInt("legajo_mecanico");
                hora = rs.getString("hora");
                estado = rs.getString("estado");
                agenda = new AgendaDTO(ano_mes, legajo_mecanico, dia, hora, estado);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }
    
    @Override
    public List<AgendaDTO> listarAgendaPorAnoMes(String anoMes) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * "
                        + "from agendas "
                        + "where ano_mes = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, anoMes);
            
            rs = sentencia.executeQuery();

            String ano_mes;
            int legajo_mecanico;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                legajo_mecanico = rs.getInt("legajo_mecanico");
                agenda = new AgendaDTO(ano_mes, legajo_mecanico);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }
}
