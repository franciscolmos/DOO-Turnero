/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AgendaDTO;
import dto.MecanicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            String sql = "select * "
                        + "from agendas "
                        +   "join turnos "
                        +       "on agendas.ano_mes = turnos.ano_mes "
                        +          " and  agendas.legajo_mecanico = turnos.legajo_mecanico "
                        + "where estado = ? and turnos.legajo_mecanico = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, legajoMecanico);
            
            System.out.println(sentencia);
            
            rs = sentencia.executeQuery();

            String ano_mes;
            int legajo_mecanico;
            String dia;
            String hora;
            String estado;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                legajo_mecanico = rs.getInt("legajo_mecanico");
                dia = rs.getString("dia");
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
    
        if(this.listarAgendas().size() > 0){
            System.out.println("entro");
            return false;
        }else{
            for (int i = 0; i < listadoMecanicos.size(); i++) {
                try {
                    con = conexion.getConnection();

                    String sql =  "insert into agendas (ano_mes, legajo_mecanico)"
                                + "values(?,?)";
                    sentencia = con.prepareStatement(sql);
                    sentencia.setString(1, "2021-07");
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
    public List<AgendaDTO> listarAgendaPorFecha(String legajoMecanico, String estadoTurno, String fecha) {
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
                        +   "and dia = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, legajoMecanico);
            sentencia.setString(3, fecha);
            
            System.out.println(sentencia);
            
            rs = sentencia.executeQuery();

            String ano_mes;
            int legajo_mecanico;
            String dia;
            String hora;
            String estado;
            AgendaDTO agenda;

            while (rs.next()) {
                ano_mes = rs.getString("ano_mes");
                legajo_mecanico = rs.getInt("legajo_mecanico");
                dia = rs.getString("dia");
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

    
    // revisar este METODO porque la agenda no tiene estado, habria que modificar el estado del turno realmente, creo que podriamos borrar este metodo no nos va a servir
    @Override
    public boolean modificarAgenda(String dia, String horario, String mecanico) {
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            con = conexion.getConnection();
            String sql = "update agendas set estado=? where dia=? "
                       + "and horario=? and mecanico=?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, "Asignado");
            sentencia.setString(2, dia);
            sentencia.setString(3, horario);
            sentencia.setString(4, mecanico);

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
}
